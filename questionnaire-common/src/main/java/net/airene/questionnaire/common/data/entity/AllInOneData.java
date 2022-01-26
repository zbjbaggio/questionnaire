package net.airene.questionnaire.common.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 酒店数据表 t_merch_data
 *
 * @author YANQING
 * @date 2021-08-30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class AllInOneData extends BaseEntity implements Serializable {

	// 设备id
	private Long allInOneId;

	// 绿云预订号
	private String rsvNo;

	// 入住日期
	private Date rsvArrDate;

	// 离店日期
	private Date rsvDepDate;

	/** 入住天数 */
	private Long stayDateCount;

	/** 花费总时长（单位秒） */
	private Long usedTimes;

	// 办理时间
	private Date startTime;

	// 入住房型
	private String rmType;

	// 入住房号
	private String roomNo;

	// 入住人姓名 张三，李四
	private String names;

	// 订单渠道
	private String channelDes;

	// 订单备注
	private String remark;

}
