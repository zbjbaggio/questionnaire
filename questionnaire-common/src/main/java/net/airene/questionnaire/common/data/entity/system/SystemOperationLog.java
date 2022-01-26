package net.airene.questionnaire.common.data.entity.system;

import net.airene.questionnaire.common.data.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * 后台系统操作记录表 t_system_operation_log
 *
 * @author eason
 * @date 2020-09-04
 */
@Data
@ToString(callSuper = true)
public class SystemOperationLog extends BaseEntity {

	/** 管理用户id */
	private Long userId;

	/** 动作名称 */
	private String operationName;

	/** 请求url */
	private String url;

	/** 参数 */
	private String params;

	/**
	 * ip地址
	 */
	private String ip;

}
