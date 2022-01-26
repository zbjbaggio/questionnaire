package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.lvPMS.LvPMSReturnMsg;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 房间信息返回类
 * @date 2021年08月31日 17:48
 */
@Data
public class LvPMSRoomInfoResponseDTO extends LvPMSReturnMsg implements Serializable {

    private List<LvPMSRoomInfoDTO> result;
}
