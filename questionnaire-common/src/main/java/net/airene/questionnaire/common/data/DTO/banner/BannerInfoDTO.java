package net.airene.questionnaire.common.data.DTO.banner;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc banner信息
 * @date 2021/9/8
 */
@Data
public class BannerInfoDTO implements Serializable {

    // 广告类型 1 图片 2 视频
    private Integer type;

    // 广告位置 1 首页 2 banner
    private Integer location;

    // 地址
    private String url;

    // 顺序
    private Integer sort;
}
