package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.lvPMS.LvPMSReturnMsg;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 房型信息返回类
 * @date 2021/11/16
 */
@Data
public class LvPMSRoomTypeResponseDTO extends LvPMSReturnMsg implements Serializable {

    private List<LvPMSRoomTypeDTO> result;
}
