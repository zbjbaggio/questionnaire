package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 增加同住人
 * @date 2021年05月28日 10:19
 */
@Data
public class LvPMSAddPeopleResponseDTO {
    /**
     * 应支付金额
     * 0 添加同住人成功
     * -1 当前主单不存在或不是在住状态
     * -2 Q04参数解析错误
     * -3 出生日期格式不能解析
     */
    private String C00;
}
