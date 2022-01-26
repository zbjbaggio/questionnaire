package net.airene.questionnaire.common.data.DTO.userCenter;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 查询是否注册会员请求类
 * @date 2021年08月30日 14:19
 */
@Data
public class IsRegistRequestDTO implements Serializable {

    private IsRegistDTO params;

    @Data
    public static class IsRegistDTO {

        private String phone;

        private String userId;

        private String checkPhone;
    }

}
