package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import net.airene.questionnaire.common.enums.QueryOrderTypeEnum;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 订单信息查询类
 * @date 2021年08月30日 9:49
 */
@Data
@ToString(callSuper = true)
public class LvPMSOrderRequestDTO extends BaseRequestDTO implements Serializable {

    @NotEmpty
    private String queryNo;

    /**
     * 类型
     * 1 身份证  2 手机号  3 姓名
     * {@link QueryOrderTypeEnum}
     */
    private Integer type;

    // 酒店代码
    private String hotelCode;
}
