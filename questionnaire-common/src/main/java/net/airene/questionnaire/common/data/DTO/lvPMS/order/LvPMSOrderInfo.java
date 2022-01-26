package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 订单信息
 * @date 2021年09月02日 13:12
 */
@Data
public class LvPMSOrderInfo implements Serializable {

    // 酒店代码
    private String hotelCode;

    // 是否是盛行会员
    private String isRegister;

    // 预留手机号
    private String phone;

    private List<LvPMSOrderRoomInfo> roomList;

    @Getter
    @AllArgsConstructor
    public enum DescriptionEnum {

        HAS(1, "有空房"),
        NO(2, "无空房"),
        ;

        private Integer value;

        private String name;


    }

}
