package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.lvPMS.LvPMSReturnMsg;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 入住返回类 与添加同住人共用
 * @date 2021年09月02日 10:22
 */
@Data
public class LvPMSCheckInResponseDTO extends LvPMSReturnMsg implements Serializable {

    private List<LvPMSCheckInDTO> result;
}
