package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 报查房
 * @date 2021年05月27日 19:30
 */
@Data
public class LvPMSReportCheckRoomResponseDTO {
    /**
     * 入住单PMS编码
     */
    private String C00;

    /**
     * 结账结果(1-成功,2-失败)
     */
    private String C01;
}
