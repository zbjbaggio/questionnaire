package net.airene.questionnaire.common.data.DTO.lvPMS.PMS;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 房间特征表
 * @date 2021年05月28日 11:20
 */
@Data
public class LvPMSRoomFeatureInfoResponseDTO {
    /**
     * PMS房间特征编码
     */
    private String C00;

    /**
     * PMS房间特征描述
     */
    private String C01;
}
