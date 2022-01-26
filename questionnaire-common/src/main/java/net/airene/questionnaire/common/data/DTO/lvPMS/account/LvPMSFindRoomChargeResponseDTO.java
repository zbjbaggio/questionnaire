package net.airene.questionnaire.common.data.DTO.lvPMS.account;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 房费加收
 * @date 2021年05月28日 11:14
 */
@Data
public class LvPMSFindRoomChargeResponseDTO {
    /**
     * 入住单PMS编码
     */
    private String C00;

    /**
     * 是否加收房费(1-是,2-否,3-不确定)
     */
    private String C01;

    /**
     * 应加收的房费
     */
    private String C02;

    /**
     * 账户余额
     */
    private String C03;

    /**
     * 加收费用类型（0-不加收,1-半天,2-全天,3-钟点房）
     */
    private String C04;
}
