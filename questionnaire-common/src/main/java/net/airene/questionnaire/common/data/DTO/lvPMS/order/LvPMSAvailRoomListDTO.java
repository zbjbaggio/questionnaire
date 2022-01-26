package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LvPMSAvailRoomListDTO implements Serializable {

    private List<LvPMSAvailRoomDTO> roomList;
}
