package net.airene.questionnaire.common.data.DTO.lvPMS.PMS;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询PMS楼层列表DTO
 * @date 2021年05月28日 11:26
 */
@Data
public class LvPMSFloorInfoRequestDTO {
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
     * 楼宇PMS编码
     */
    private String Q03;
}
