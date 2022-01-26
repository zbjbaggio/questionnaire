package net.airene.questionnaire.common.data.DTO.lvPMS.PMS;

import lombok.Data;

/**
 * @author LiPang
 * @Desc PMS楼层信息
 * @date 2021年05月28日 11:26
 */
@Data
public class LvPMSFloorInfoResponseDTO {
    /**
     * 楼层PMS编码
     */
    private String C00;

    /**
     * 楼层序号
     */
    private String C01;

    /**
     * 楼层名称
     */
    private String C02;

    /**
     * 楼层状态(1-有效,2-无效)
     */
    private String C03;

    /**
     * 所属楼宇PMS编码
     */
    private String C04;
}
