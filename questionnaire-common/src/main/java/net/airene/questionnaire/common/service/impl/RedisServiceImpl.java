package net.airene.questionnaire.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.common.constant.RedisConstants;
import net.airene.questionnaire.common.data.DTO.AllInOneDTO;
import net.airene.questionnaire.common.data.VO.system.SystemUserVO;
import net.airene.questionnaire.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 描述：
 * Created by jay on 2017-9-28.
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RedisServiceImpl implements RedisService {

    private final StringRedisTemplate template;

    @Override
    public void saveAllInOne(AllInOneDTO allInOneDTO) {
        save(RedisConstants.ALL_ONE_IN + allInOneDTO.getCode(), allInOneDTO, RedisConstants.ALL_ONE_IN_TIME, TimeUnit.MINUTES);
    }

    @Override
    public AllInOneDTO getAllInOne(String code) {
        String value = get(RedisConstants.ALL_ONE_IN + code);
        return JSONObject.parseObject(value, AllInOneDTO.class);
    }

    @Override
    public void saveLvPMSSessionId(String value) {
        save(RedisConstants.LVPMS, value, RedisConstants.LVPMS_CACHE_TIME, TimeUnit.HOURS);
    }

    @Override
    public String getLvPMSSessionId(String key) {
        return get(key);
    }

    @Override
    public void saveCaptcha(String captcha, String value) {
        save(RedisConstants.CAPTCHA + captcha, value, RedisConstants.CAPTCHA_TIME, TimeUnit.MINUTES);
    }

    /**
     * 删除手机端用户缓存
     * @param userId
     */
    @Override
    public void deleteSystemLogin(Long userId) {
        template.delete(RedisConstants.SYSTEM_USER_LOGIN_KEY + userId);
    }

    /**
     * 系统登录用户信息保存
     * @param login 登录用户信息
     */
    @Override
    public void saveSystemLogin(SystemUserVO login) {
        save(RedisConstants.SYSTEM_USER_LOGIN_KEY + login.getId(), login, RedisConstants.SYSTEM_USER_LOGIN_MINUTES, TimeUnit.MINUTES);
    }

    /**
     * 获取系统登录用户信息
     * @param userId 用户名
     * @return 登录用户信息
     */
    @Override
    public SystemUserVO getSystemLogin(Long userId) {
        return get(RedisConstants.SYSTEM_USER_LOGIN_KEY + userId, SystemUserVO.class);
    }

    @Override
    public void deletePermission(Long userId) {
        template.delete(RedisConstants.SYSTEM_PERMISSION + userId);
    }

    @Override
    public void reExpireSystemLogin(SystemUserVO login) {
        boolean expire = expire(RedisConstants.SYSTEM_USER_LOGIN_KEY + login.getId(), RedisConstants.SYSTEM_USER_LOGIN_MINUTES, TimeUnit.MINUTES);
        // 重置过期时间失败，重新保存
        if (!expire) {
            saveSystemLogin(login);
        }
    }

    @Override
    public String getCaptcha(String captcha){
        return get(RedisConstants.CAPTCHA + captcha, String.class);
    }

    @Override
    public void deleteCaptcha(String captcha) {
        delete(RedisConstants.CAPTCHA + captcha);
    }

    @Override
    public void saveNationList(Map<String, String> map) {
        save(RedisConstants.ENUO_NATION, map);
    }

    @Override
    public String getNation(String keyValue) {
        return (String)get(RedisConstants.ENUO_NATION, keyValue);
    }

    private void save(String key, Object value, long time, TimeUnit timeUnit) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, JSON.toJSONString(value), time, timeUnit);
    }

    private void save(String key, Map map) {
        template.opsForHash().putAll(key, map);
    }

    private Object get(String keyRedis, String keyValue) {
       return template.opsForHash().get(keyRedis, keyValue);
    }

    private void save(String key, Object value) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, JSON.toJSONString(value));
    }

    private <T> T get(String key, Class<T> clazz) {
        ValueOperations<String, String> ops = template.opsForValue();
        String value = ops.get(key);
        T t = null;
        if (value != null && value.length() > 0) {
            t = JSON.parseObject(value, clazz);
        }
        return t;
    }

    private void save(String key, String value, long time, TimeUnit timeUnit) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value, time, timeUnit);
    }

    private String get(String key) {
        ValueOperations<String, String> ops = template.opsForValue();
        return ops.get(key);
    }

    private void delete(String key) {
        template.delete(key);
    }

    /**
     * 重置过期时间
     * @param key
     * @param time
     * @param timeUnit
     */
    private boolean expire(String key, long time, TimeUnit timeUnit) {
        return template.expire(key, time, timeUnit);
    }

}
