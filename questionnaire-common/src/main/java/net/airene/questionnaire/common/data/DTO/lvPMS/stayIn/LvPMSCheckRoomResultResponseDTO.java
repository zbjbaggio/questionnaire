package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查房结果
 * @date 2021年05月27日 19:32
 */
@Data
public class LvPMSCheckRoomResultResponseDTO {
    /**
     * 入住单PMS编码
     */
    private String C00;

    /**
     * 结果(9-查房完成,其他值-查房未完成)
     */
    private String C01;
}
