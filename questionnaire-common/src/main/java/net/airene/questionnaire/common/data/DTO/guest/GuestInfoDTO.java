package net.airene.questionnaire.common.data.DTO.guest;

import net.airene.questionnaire.common.annotation.validation.AllowableValue;
import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString(callSuper = true, exclude = {"photo", "idPhoto"})
public class GuestInfoDTO extends BaseRequestDTO implements Serializable {

    /**
     * 境内境外标识 0 境内  1 境外
     */
    @AllowableValue(intValues = {0, 1}, groups = {EnuoForeignGuestIn.class, EnuoGeneralGuestIn.class})
    public Integer sign;

    /**
     * 旅馆编码
     */
    //@NotNull(groups = {EnuoForeignGuestIn.class, EnuoGeneralGuestIn.class})
    private String hotelCode;

    /**
     * 房间编码
     */
    @NotNull(groups = {EnuoForeignGuestIn.class, EnuoGeneralGuestIn.class})
    private String roomCode;

    /**
     * 预计离店时间
     * yyyy-MM-dd HH:mm:ss
     */
    private String endTime;

    /**
     * 入住时间
     * yyyy-MM-dd HH:mm:ss
     */
    @NotNull(groups = {EnuoForeignGuestIn.class, EnuoGeneralGuestIn.class})
    private String startTime;

    /**
     *证件号码
     */
    @NotNull(groups = {EnuoGeneralGuestIn.class})
    private String idCard;

    /**
     * 性别
     * 1男2女
     */
    //@NotNull(groups = {EnuoForeignGuestIn.class, EnuoGeneralGuestIn.class})
    private String sex;

    /**
     * 出生日期
     * yyyy-MM-dd
     */
    //@NotNull(groups = {EnuoGeneralGuestIn.class})
    private String birthday;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 复核人
     */
    @NotEmpty(groups = {EnuoForeignGuestIn.class, EnuoGeneralGuestIn.class})
    private String reviewer;

    /**
     * 现场照片
     */
    @NotEmpty(groups = {EnuoForeignGuestIn.class, EnuoGeneralGuestIn.class, EnuoGuestPhoto.class})
    private String photo;

    /**
     * 证件照片
     */
    @NotEmpty(groups = {EnuoForeignGuestIn.class, EnuoGeneralGuestIn.class, EnuoGuestPhoto.class})
    private String idPhoto;

    /**
     * 对比结果
     */
    private String comparisionResult;

    /**
     * 对比相似度
     */
    private String contrastSimilarity;

    // 境外
    /**
     * 中文名
     */
    private String chineseName;

    /**
     * 国籍地区
     */
    @NotNull(groups = {EnuoForeignGuestIn.class})
    private String nationality;

    /**
     * 英文姓
     */
    private String surname;

    /**
     * 英文名
     */
    private String firstName;

    /**
     * 签发机关
     */
    //private String issuingAuthority;

    /**
     * 签证种类
     */
    //private String visaType;

    /**
     * 签证号码
     */
    //private String visaNo;

    /**
     * 在华停留至
     */
    //private String leaveDate;

    /**
     * 入境日期
     */
    //private String entryDate;

    /**
     * 入境口岸
     */
    //private String entryPort;

    /**
     * 证件有效期
     */
    //private String validDate;

    /**
     * 接待单位
     */
    //private String receptionUnit;

    /**
     * 接待人
     */
    //private String receptionist;

    /**
     * 从何地来
     */
    //private String CHDL;

    /**
     * 到何地去
     */
    //private String DHDQ;

    /**
     * 停留事由
     */
    //private String TLSY;

    /**
     * 职业
     */
    //private String ZY;

    /**
     * 出生地
     */
    //private String CSD;

    /**
     * 血统
     */
    //private String XT;

    /**
     * 邀请人
     */
    //private String YQR;

    /**
     * 拟离开日期
     */
    //private String NLKRQ;

    /**
     * 备注
     */
    //private String BZ;

    /**
     * 证件种类
     */
    private String documentType;

    /**
     * 姓名
     */
    @NotNull(groups = {EnuoGeneralGuestIn.class})
    private String name;

    /**
     * 民族
     */
    @NotNull(groups = {EnuoGeneralGuestIn.class})
    private String nation;

    /**
     * 省市县
     */

    private String cities;

    /**
     * 详细地址
     */
    @NotNull(groups = {EnuoGeneralGuestIn.class})
    private String address;

    /**
     * 一诺境内入住校验
     */
    public interface EnuoGeneralGuestIn {

    }

    /**
     * 一诺境外入住校验
     */
    public interface EnuoForeignGuestIn {

    }

    public interface EnuoGuestPhoto {

    }

}
