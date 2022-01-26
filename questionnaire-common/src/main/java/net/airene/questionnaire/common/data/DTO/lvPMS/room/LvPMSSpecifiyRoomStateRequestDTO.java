package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;
import lombok.ToString;

/**
 * @author LiPang
 * @Desc 查询指定房态DTO
 * @date 2021年05月27日 17:50
 */
@Data
public class LvPMSSpecifiyRoomStateRequestDTO {
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
     * 开始日期
     */
    private String Q03;

    /**
     * 结束日期
     */
    private String Q04;

    /**
     * 房号
     */
    private String Q05;
}
