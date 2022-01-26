package net.airene.questionnaire.common.data.DTO;

import net.airene.questionnaire.common.data.entity.AllInOneInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AllInOneDTO extends AllInOneInfo implements Serializable {

    // 酒店名称
    private String hotelName;
    
    private String token;

}
