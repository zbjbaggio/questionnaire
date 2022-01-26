package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 锁房
 * @date 2021年05月27日 18:34
 */
@Data
public class LvPMSLockRoomResponseDTO {
    /**
     * 锁定结果(1-操作成功,2-操作失败)
     */
    private String C00;

    /**
     * 锁房标记值
     */
    private String C01;
}
