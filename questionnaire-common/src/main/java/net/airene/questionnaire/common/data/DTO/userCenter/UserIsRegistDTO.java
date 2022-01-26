package net.airene.questionnaire.common.data.DTO.userCenter;

import net.airene.questionnaire.common.data.DTO.member.RegistMemberQueryDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 查询是否注册了会员
 * @date 2021年08月30日 14:17
 */
@Data
@ToString(callSuper = true)
public class UserIsRegistDTO extends UserCenterReturnMsg implements Serializable {

    private RegistMemberQueryDTO data;
}
