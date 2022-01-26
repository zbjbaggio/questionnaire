package net.airene.questionnaire.common.data.DTO.lvPMS.account;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询房费加收DTO
 * @date 2021年05月28日 11:13
 */
@Data
public class LvPMSFindRoomChargeRequestDTO {
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
     * 入住单PMS编码
     */
    private String Q03;
}
