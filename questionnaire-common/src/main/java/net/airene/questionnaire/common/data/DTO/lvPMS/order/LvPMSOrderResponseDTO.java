package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.lvPMS.LvPMSReturnMsg;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 查询订单信息返回类
 * @date 2021年08月30日 13:56
 */
@Data
public class LvPMSOrderResponseDTO extends LvPMSReturnMsg implements Serializable {

    private String isRegister;

    private List<LvPMSOrderInfoDTO> result;

}
