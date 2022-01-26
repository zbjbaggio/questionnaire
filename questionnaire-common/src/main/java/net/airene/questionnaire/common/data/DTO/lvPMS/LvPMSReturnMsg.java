package net.airene.questionnaire.common.data.DTO.lvPMS;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 绿云接口返回信息
 * @date 2021年08月30日 13:34
 */
@Data
public class LvPMSReturnMsg implements Serializable {

    private Integer resultCode;

    private String resultMsg;

    private Object result;
}