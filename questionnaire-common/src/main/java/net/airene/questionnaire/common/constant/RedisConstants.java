package net.airene.questionnaire.common.constant;

/**
 * redis key常量
 */
public interface RedisConstants {
    
    // 缓存默认时间 小时
    long DEFAULT_CACHE_TIME = 24L;
    // 一体机redisKey
    String ALL_ONE_IN = "all_one_in_";
    // 一体机redis缓存时间 30分钟
    long ALL_ONE_IN_TIME = 30L;
    // 绿云redisKey
    String LVPMS = "lvPMS_sessionId";
    long LVPMS_CACHE_TIME = 22L;
    //  图形验证码过期时间 分钟
    long CAPTCHA_TIME = 1L;
    // 验证码redisKey
    String CAPTCHA = "captcha_";
    // 一诺旅业民族字典
    String ENUO_NATION = "enuo_nation";
    // 管理系统用户登录key前缀
    String SYSTEM_USER_LOGIN_KEY = "system_user_login_";

    // 管理系统用户保存redis时长为30分钟
    int SYSTEM_USER_LOGIN_MINUTES = 30;

    String SYSTEM_PERMISSION = "shiro:cache:net.airene.questionnaire.admin.shiro.ShiroRealm.authorizationCache:";


}
