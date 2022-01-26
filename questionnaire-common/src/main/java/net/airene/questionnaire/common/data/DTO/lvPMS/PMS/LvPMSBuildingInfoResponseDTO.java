package net.airene.questionnaire.common.data.DTO.lvPMS.PMS;

import lombok.Data;

/**
 * @author LiPang
 * @Desc PMS楼宇信息
 * @date 2021年05月28日 11:25
 */
@Data
public class LvPMSBuildingInfoResponseDTO {
    /**
     * 楼宇PMS编码
     */
    private String C00;

    /**
     * 楼宇名称
     */
    private String C01;
}
