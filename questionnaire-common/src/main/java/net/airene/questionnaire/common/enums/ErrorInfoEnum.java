package net.airene.questionnaire.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误信息
 * Created by eason on 2017-2-22.
 */
@Getter
@AllArgsConstructor
public enum ErrorInfoEnum {
    SUCCESS(200, "ok"),
    ERROR(500, "系统异常"),
    // 第三方请求失败
    INCHECK_ERROR(30001, "旅业接口请求失败！"),
    //  订单相关
    THIRD_CALL_ERROR(30002, "第三方接口调用失败！"),
    QUERY_ORDER_ERROR(30003, "查询订单信息失败！"),
    QUERY_ORDER_DETAIL_ERROR(30004, "查询订单详细信息失败！"),
    QUERY_ORDER_ROOM_ERROR(30005, "查询房间信息失败！"),
    QUERY_BASE_CODE_ERROR(30006, "查询基础代码信息失败！"),
    QUERY_AVAIL_ROOM_ERROR(30007, "查询基础代码信息失败！"),
    ALL_ROOM_TAKE_UP_ERROR(30008, "当前房间不可办理入住，请选择其他房间!"),
    NO_ROOM_ERROR(30009, "当前无可办理入住的房间，请到前台咨询!"),
    TERRACED_ROOM_ERROR(30010, "排房失败！"),
    ADD_GUEST_ERROR(30011, "添加同住人失败！"),
    CHECK_IN_ERROR(30012, "入住失败！"),
    ENUO_ERROR(30013, "通讯失败，请重新办理！"),
    NO_FREE_ROOM_ERROR(30014, "无空房可入住"),
    QUERY_ROOM_TYPE_ERROR(30015, "查询房型信息失败！"),
    // 会员相关
    REGIST_ERROR(40001, "注册失败，该手机号已注册!"),
    NO_CAPTCHA(40002, "不使用验证码！"),

    // 公共的错误
    PARAMS_ERROR(50001, "参数错误！"),
    ALL_IN_ONE_UNUSED_ERROR(50002, "当前不可办理，请到前台咨询！"),
    TOKEN_ERROR(50003, "token失效！"),
    CAPTCHA_OVERTIME(50004, "验证码超时！"),
    CAPTCHA_ERROR(50005, "验证码错误！"),
    CODE_TIME_OUT(50022, "验证码超时，请重试！"),
    CODE_ERROR(50023, "验证码不正确！"),
    ADD_ERROR(50011, "新增失败！"),
    UPDATE_ERROR(50015, "修改失败！"),

    // 与系统用户角色权限相关的错误 6 开头
    LOGIN_ERROR(60001, "用户名或密码错误！"),
    LOGIN_AGAIN(60002, "重新登录！"),
    NO_LOGIN(60003, "未登录！"),
    NO_AUTHORITY(60004, "您的账号没有开通功能，请联系负责人进行开通"),//"该用户没有功能权限！"),
    USERNAME_SAME(60005, "用户名重复！"),
    REGISTER_ERROR(60006, "用户注册失败！" ),
    USER_LOCKED(60007, "该用户已被锁定，请联系管理员！" ),
    USER_UNACTIVATED(60008, "该用户还未审核通过请耐心等待！"),
    USER_NO_LOGIN(60009, "该用户已冻结请1个小时后再试！"),
    ROLE_NAME_SAME(60009, "角色名重复！"),
    REMOVE_ROLE_USER(60010, "请先将该角色用户移除！"),
    TIME_REPEAT(60011, "上线时间重复！"),
    LOGIN_ERROR_THIRD(60012, "登录失败，请重试！"),
    LOGIN_ERROR_FORBIDDEN(60012, "用户暂不允许登录，请咨询管理员！"),
    LOGIN_ERROR_USER_NOT_EXIST(60012, "用户不存在！"),

    ;

    private final int value;

    private final String name;

}
