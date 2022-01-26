package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 基础代码信息类
 * @date 2021年08月31日 18:22
 */
@Data
public class LvPMSBaseCodeDTO implements Serializable {

    // 是否停用 T-停用 F-未停用
    private String isHalt;

    // 描述
    private String descript;

    // 代码
    private String code;
}
