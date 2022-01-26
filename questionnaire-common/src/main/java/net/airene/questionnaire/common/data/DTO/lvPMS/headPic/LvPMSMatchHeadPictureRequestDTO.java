package net.airene.questionnaire.common.data.DTO.lvPMS.headPic;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 住客头像显示在主单信息DTO
 * @date 2021年05月28日 10:29
 */
@Data
public class LvPMSMatchHeadPictureRequestDTO {
    /**
     * 预留
     */
    private String Q00;

    /**
     * 预留
     */
    private String Q01;

    /**
     * 酒店PMS编码
     */
    private String Q02;

    /**
     * 主单PMS编码
     */
    private String Q03;

    /**
     * 证件头像BASE64编码
     */
    private String Q04;

    /**
     * 住客证件号码
     */
    private String Q05;
}
