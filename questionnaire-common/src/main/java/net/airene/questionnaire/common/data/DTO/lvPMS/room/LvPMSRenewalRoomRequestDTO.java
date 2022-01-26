package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询可续住房DTO
 * @date 2021年05月27日 18:16
 */
@Data
public class LvPMSRenewalRoomRequestDTO {
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
     * 登记单ID
     */
    private String Q03;

    /**
     * 离店时间
     * 格式:yyyy-MM-dd HH:mm:ss
     */
    private String Q04;
}
