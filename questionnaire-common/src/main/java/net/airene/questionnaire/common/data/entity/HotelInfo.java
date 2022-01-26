package net.airene.questionnaire.common.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 酒店表 t_hotel_info
 *
 * @author YANQING
 * @date 2021-06-01
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class HotelInfo extends BaseEntity {

	/** 酒店编号 */
	private String code;

	/** 酒店名称 */
	private String name;

}
