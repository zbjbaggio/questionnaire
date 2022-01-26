package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.lvPMS.LvPMSReturnMsg;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 可用房明细返回类
 * @date 2021年09月01日 11:27
 */
@Data
public class LvPMSAvailRoomResponseDTO extends LvPMSReturnMsg implements Serializable {

    private List<LvPMSAvailRoomDTO> result;
}
