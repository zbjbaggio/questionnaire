package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.lvPMS.LvPMSReturnMsg;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 基础代码返回类
 * @date 2021年08月31日 18:24
 */
@Data
public class LvPMSBaseCodeResponseDTO extends LvPMSReturnMsg implements Serializable {

    private List<LvPMSBaseCodeDTO> result;
}
