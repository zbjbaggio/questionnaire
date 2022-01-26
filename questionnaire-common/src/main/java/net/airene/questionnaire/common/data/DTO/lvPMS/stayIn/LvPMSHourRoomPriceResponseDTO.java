package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 钟点房房价
 * @date 2021年05月28日 10:23
 */
@Data
public class LvPMSHourRoomPriceResponseDTO {
    /**
     * 房价代码
     */
    private String C00;

    /**
     * 房型
     */
    private String C01;

    /**
     * 基础小时数
     */
    private String C02;

    /**
     * 基础价格
     */
    private String C03;

    /**
     * 超时时长基数
     */
    private String C04;

    /**
     * 超时时长基数价格
     */
    private String C05;

    /**
     * 最大入住时间
     */
    private String C06;

    /**
     * 开放时间段
     */
    private String C07;
}
