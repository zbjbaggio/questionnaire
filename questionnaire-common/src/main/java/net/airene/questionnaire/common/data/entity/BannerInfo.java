package net.airene.questionnaire.common.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc banner
 * @date 2021/9/8
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BannerInfo extends BaseEntity implements Serializable {

    // 商户ID
    private String merchId;

    // 标题
    private String title;

    // 广告类型 1 图片 2 视频
    private Integer type;

    // 广告位置 1 首页 2 banner
    private Integer location;

    // 地址
    private String url;

    // 状态 1 上架 0 下架
    private Integer status;

    // 顺序
    private Integer sort;
}
