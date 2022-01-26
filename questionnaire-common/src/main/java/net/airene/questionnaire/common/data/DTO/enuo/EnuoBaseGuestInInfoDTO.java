package net.airene.questionnaire.common.data.DTO.enuo;

import lombok.Data;

import java.io.Serializable;

/**
 * 一诺365入住旅客基本信息
 */
@Data
public class EnuoBaseGuestInInfoDTO implements Serializable {

    public EnuoBaseGuestInInfoDTO(int sign) {
        this.sign = sign;
    }

    private Integer sign;

    /**
     * 旅馆编码
     */
    private String LVBM;

    /**
     * 房间编码
     */
    private String FJBM;

    /**
     * 预计离店时间
     * yyyy-MM-dd HH:mm:ss
     */
    private String YJLDSJ;

    /**
     * 入住时间
     * yyyy-MM-dd HH:mm:ss
     */
    private String RZSJ;

    /**
     *证件号码
     */
    private String ZJHM;

    /**
     * 性别
     * 1男2女
     */
    private String XB;

    /**
     * 出生日期
     * yyyy-MM-dd
     */
    private String CSRQ;

    /**
     * 联系电话
     */
    private String LXDH;

    /**
     * 复核人
     */
    private String FHR;

    /**
     * 现场照片
     */
    private String XCZP;

    /**
     * 证件照片
     */
    private String ZJZP;

    /**
     * 对比结果
     */
    private String DBJG;

    /**
     * 对比相似度
     */
    private String DBXSD;

}
