package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.lvPMS.LvPMSReturnMsg;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 订单详细信息返回类
 * @date 2021年08月31日 16:15
 */
@Data
public class LvPMSOrderDetailResponseDTO extends LvPMSReturnMsg implements Serializable {

    // 订单号
    private String accnt;

    // 订单详情
    private List<LvPMSOrderDetailDTO> result;
}
