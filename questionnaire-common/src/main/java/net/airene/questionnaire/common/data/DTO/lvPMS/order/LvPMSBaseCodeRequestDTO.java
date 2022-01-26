package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 基础代码请求类
 * @date 2021年08月31日 18:26
 */
@Data
public class LvPMSBaseCodeRequestDTO implements Serializable {

    // 酒店代码
    private String hotelCode;

    /**
     * 基础代码类别
     *
     * market–市场代码
     * src–来源代码
     * channe-渠道代码
     * rsvType–预定类型代码
     * visaType-签证类型代码
     * enterPort-入境口岸代码
     * idCode-证件类型代码
     * sex-性别代码
     * feature-房间特征
     * package-包价
     * floor-楼层
     * building-楼栋
     * roomSta- 房态代码
     * roomStaOcc-空闲/占用标识
     * codeRoomTmp-临时态代码
     */
    private String type;
}
