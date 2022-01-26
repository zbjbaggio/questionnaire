package net.airene.questionnaire.common.util;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtUtil {

	@NacosValue(value = "${jwt.secret:null}", autoRefreshed = true)
	private String JWTSecret;

	/**
	 * 保存到JWT 中的员工id key
	 */
	public final String CODE = "code";

	public final String SIGN_TIME = "signTime";

	/**
	 * 保存到JWT 中的员工id key
	 */
	public final String USER_ID = "userId";

	/**
	 * 校验JWT token
	 *
	 * @param token  密钥
	 * @return true 校验成功 false 校验失败
	 */
	public boolean verify(String token) {
		try {
			// 根据密码、签名算法生成JWT效验器
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JWTSecret)).build();
			// 效验TOKEN
			verifier.verify(token);
			return true;
		} catch (Exception exception) {
			log.error("JWT验证失败！", exception);
			return false;
		}
	}

	/**
	 * 获得token中的信息
	 *
	 * @return token中包含的员工id
	 */
	public String getCODE(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim(CODE).asString();
		} catch (Exception e) {
			log.error("JWT解析userId失败！", e.getMessage());
			return null;
		}
	}

	/**
	 * 生成签名,5min后过期
	 *
	 * @param code
	 * @return 加密的token
	 */
	public String sign(String code) {
		// 附带userId信息
		return JWT.create().withClaim(CODE, code)
				.withClaim(SIGN_TIME, System.currentTimeMillis())
				.sign(Algorithm.HMAC256(JWTSecret));
	}

	public String getUserId(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim(USER_ID).asString();
		} catch (JWTDecodeException e) {
			log.error("JWT解析userId失败！", e);
			return null;
		}
	}
}
