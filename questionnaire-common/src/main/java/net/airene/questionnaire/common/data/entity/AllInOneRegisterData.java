package net.airene.questionnaire.common.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LiPang
 * @Desc 一体机注册用户表
 * @date 2021/11/16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class AllInOneRegisterData extends BaseEntity implements Serializable {

    // 设备编号
    private String code;

    // 酒店id
    private String merchId;

    // 酒店名称
    private String merchIdDes;

    // 注册时间
    private Date registerDate;

    // 手机号
    private String phone;

    // 一体机id
    private Long allInOneId;
}
