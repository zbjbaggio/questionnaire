package net.airene.questionnaire.common.data.DTO.userCenter;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 查询是否会员返回类
 * @date 2021/9/9
 */
@Data
public class UserIsRegistResponseDTO implements Serializable {

    private String isRegister;
}
