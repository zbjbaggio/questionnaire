package net.airene.questionnaire.common.data.DTO.member;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 注册会员信息
 * @date 2021年08月30日 13:07
 */
@Data
public class RegistMemberDTO implements Serializable {

    private String isRegist;

    private String isSame;

    private String isEmp;

    private String nationalId;

    private String hasLoginPw;

    private String hasPayPw;
}
