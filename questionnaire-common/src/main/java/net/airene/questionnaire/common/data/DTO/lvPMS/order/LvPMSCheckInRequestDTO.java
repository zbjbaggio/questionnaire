package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 入住请求类
 * @date 2021年09月02日 10:22
 */
@Data
@ToString(callSuper = true)
public class LvPMSCheckInRequestDTO extends BaseRequestDTO implements Serializable {

    private List<Guest> guestList;

    // 酒店代码
    private String hotelCode;

    // 入住单ID
    private String accnt;

    // 资源id
    private String rsvSrcId;

    // 房间号
    private String roomNo;

    // 是否排房 N 未排房 Y 已排房
    private String rsvType;

    // 入住时间
    private String startTime;

    @Data
    public static class Guest{
        // 住客姓名
        private String guestName;

        // 证件号
        private String idNo;

        // 复核人
        private String reviewer;

        // 详细地址
        private String address;

        // 民族
        private String nation;

        // 现场照片
        private String photo;

        // 证件照片
        private String idPhoto;

        // 对比相似度
        private String contrastSimilarity;

        // 对比结果
        private String comparisionResult;
    }

}
