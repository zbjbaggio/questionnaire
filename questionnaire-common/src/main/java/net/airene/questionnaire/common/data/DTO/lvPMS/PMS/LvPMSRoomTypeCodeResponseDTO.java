package net.airene.questionnaire.common.data.DTO.lvPMS.PMS;

import lombok.Data;

/**
 * @author LiPang
 * @Desc PMS房型特征编码
 * @date 2021年05月28日 11:18
 */
@Data
public class LvPMSRoomTypeCodeResponseDTO {
    /**
     * PMS房类编码
     */
    private String C00;

    /**
     * PMS房类描述
     */
    private String C01;

    /**
     * PMS房号
     */
    private String C02;

    /**
     * PMS房型客房特征编码
     */
    private String C03;
}
