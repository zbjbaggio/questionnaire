package net.airene.questionnaire.common.data.DTO.lvPMS.PMS;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查看PMS房型特征编码DTO
 * @date 2021年05月28日 11:17
 */
@Data
public class LvPMSRoomTypeCodeRequestDTO {
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
     * PMS楼层编码
     */
    private String Q04;

    /**
     * PMS房类编码
     */
    private String Q05;

    /**
     * PMS房号编码
     */
    private String Q06;
}
