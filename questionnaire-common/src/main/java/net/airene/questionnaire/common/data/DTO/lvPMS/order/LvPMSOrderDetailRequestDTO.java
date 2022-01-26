package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 查询订单详细信息请求类
 * @date 2021年08月31日 16:22
 */
@Data
public class LvPMSOrderDetailRequestDTO implements Serializable {

    // 酒店代码
    private String hotelCode;

    // 账号
    private String accnt;
}
