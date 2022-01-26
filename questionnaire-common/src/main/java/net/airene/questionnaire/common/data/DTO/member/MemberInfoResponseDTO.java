package net.airene.questionnaire.common.data.DTO.member;

import net.airene.questionnaire.common.data.DTO.userCenter.UserCenterReturnMsg;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 注册用户返回信息
 * @date 2021年08月30日 17:38
 */
@Data
@ToString(callSuper = true)
public class MemberInfoResponseDTO extends UserCenterReturnMsg implements Serializable {

    private String userId;

    private String custName;

    private String status;

    private String createTime;

    private String createUser;

    private String remark;

    private String channelId;

    private String userName;

    private String phone;
}
