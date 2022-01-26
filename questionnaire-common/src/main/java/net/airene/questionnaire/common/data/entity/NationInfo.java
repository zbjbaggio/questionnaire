package net.airene.questionnaire.common.data.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 民族表 t_nation_info
 *
 * @author YANQING
 * @date 2021-08-27
 */
@Data
@ToString(callSuper = true)
public class NationInfo extends BaseEntity {

	/**  */
	private Date lastTime;

	/** 编号 */
	private String code;

	/** 名字 */
	private String name;

	/** 类型 */
	private Integer type;

}
