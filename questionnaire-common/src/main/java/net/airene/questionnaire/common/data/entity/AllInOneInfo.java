package net.airene.questionnaire.common.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 一体机表 t_all_in_one_info
 *
 * @author YANQING
 * @date 2021-06-01
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AllInOneInfo extends BaseEntity implements Serializable {

	/** 酒店id */
	private String merchId;

	/** 一体机设备编号 */
	private String code;

	/** 一体机名称 */
	private String name;

	/**
	 * 旅业接口类型
	 */
	private Integer publicSecurityInterfaceType;

	/**
	 * 复核人姓名
	 */
	private String reviewer;

	// 旅业使用
	private String hotelCode;

	// 酒店代码（绿云使用）
	private String lvHotelCode;

}
