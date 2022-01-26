package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 是否存在入住单
 * @date 2021年05月28日 10:08
 */
@Data
public class LvPMSCheckOrderResponseDTO {
    /**
     * 入住单PMS编码
     */
    private String C00;

    /**
     * 是否允许结帐(1-是,2-否)
     */
    private String C01;
}
