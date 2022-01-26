package net.airene.questionnaire.common.data.DTO.lvPMS.PMS;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询会员级别DTO
 * @date 2021年05月28日 11:32
 */
@Data
public class LvPMSMemberLevelRequestDTO {
    /**
     * 预留
     */
    private String Q00;

    /**
     * 预留
     */
    private String Q01;

    /**
     * 品牌PMS编码
     */
    private String Q02;

    /**
     * 酒店PMS编码
     */
    private String Q03;
}
