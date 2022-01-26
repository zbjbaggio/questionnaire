package net.airene.questionnaire.common.data.DTO.lvPMS.PMS;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 会员级别
 * @date 2021年05月28日 11:32
 */
@Data
public class LvPMSMemberLevelResponseDTO {
    /**
     * 会员卡类别PMS编码
     */
    private String C00;

    /**
     * 会员等级PMS编码
     */
    private String C01;

    /**
     * 会员等级名称
     */
    private String C02;

    /**
     * 最晚离店时间
     * 格式:HH:mm
     */
    private String C03;

    /**
     * 房价码
     */
    private String C04;
}
