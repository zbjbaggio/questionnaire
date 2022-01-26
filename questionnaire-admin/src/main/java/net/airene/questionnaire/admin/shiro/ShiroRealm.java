package net.airene.questionnaire.admin.shiro;

import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.common.data.VO.system.SystemUserVO;
import net.airene.questionnaire.common.mapper.system.SystemUserMapper;
import net.airene.questionnaire.common.service.RedisService;
import net.airene.questionnaire.common.util.JwtUtil;
import net.airene.questionnaire.generator.utils.StringUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private RedisService redisService;

	@Autowired
	private SystemUserMapper systemUserMapper;

	/**
	 * 必须重写此方法，不然Shiro会报错
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof JwtToken;
	}

	/**
     * 权限信息认证(包括角色以及权限)是用户访问controller的时候才进行验证(redis存储的此处权限信息)
	 * 触发检测用户权限时才会调用此方法，例如checkRole,checkPermission
     *
     * @param principals 身份信息
	 * @return AuthorizationInfo 权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (principals != null) {
			SystemUserVO systemUserVO = (SystemUserVO) principals.getPrimaryPrincipal();
			info.addStringPermissions(systemUserMapper.selectPermissionByUserId(systemUserVO.getId()));
		}
		return info;
	}

	/**
     * 用户信息认证是在用户进行登录的时候进行验证(不存redis)
	 * 也就是说验证用户输入的账号和密码是否正确，错误抛出异常
	 *
	 * @param auth 用户登录的账号密码信息
	 * @return 返回封装了用户信息的 AuthenticationInfo 实例
     * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
		String token = (String) auth.getCredentials();
		if (StringUtil.isEmpty(token)) {
			throw new AuthenticationException("token为空!");
		}
		SystemUserVO systemUserVO = checkUserTokenIsEffect(token);
		return new SimpleAuthenticationInfo(systemUserVO, token, getName());
	}

	/**
	 * 校验token的有效性
	 *
	 * @param token
	 */
	private SystemUserVO checkUserTokenIsEffect(String token) throws AuthenticationException {
		// 解密获得username，用于和数据库进行对比
		Long userId = Long.parseLong(jwtUtil.getUserId(token));
		if (Objects.isNull(userId)) {
			throw new AuthenticationException("token不正确，重新登录!");
		}
		// 校验token
		if (!jwtUtil.verify(token)) {
			throw new AuthenticationException("token校验失败，重新登录!");
		}
		//redisService.test(token);
		SystemUserVO systemLogin = redisService.getSystemLogin(userId);
		if (systemLogin == null) {
			throw new AuthenticationException("token超时，重新登录!");
		}
		if (!token.equals(systemLogin.getToken())) {
			throw new AuthenticationException("token超时，重新登录!");
		}
		redisService.reExpireSystemLogin(systemLogin);
		return systemLogin;
	}

    /**
     * 清除当前用户的权限认证缓存
     *
     * @param principals 权限信息
     */
   /* @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }*/

}
