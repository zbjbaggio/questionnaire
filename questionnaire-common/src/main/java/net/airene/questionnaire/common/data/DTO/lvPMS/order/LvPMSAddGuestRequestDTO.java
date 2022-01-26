package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 添加同住人类
 * @date 2021年09月02日 14:21
 */
@Data
@ToString
public class LvPMSAddGuestRequestDTO extends BaseRequestDTO implements Serializable {

    // 酒店代码
    private String hotelCode;

    // 入住单ID
    private String accnt;

    // 住客姓名
    private String guestName;

    // 证件类型代码
    private String idCode;

    // 证件号
    private String idNo;

    // 性别代码
    private String sex;

    // 出生日期
    private String birth;

}
