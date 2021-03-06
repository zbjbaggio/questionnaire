package net.airene.questionnaire.common.data.DTO.system;

import net.airene.questionnaire.common.data.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * 菜单权限表 t_system_permission
 *
 * @author eason
 * @date 2020-03-06
 */
@Data
@ToString(callSuper = true)
public class SystemPermission extends BaseEntity {

	/** 父类权限id */
	private Long parentId;

	/** 名称 */
	private String name;

	/** 编号用于菜单结构显示，2位一层 0102，9901 */
	private String code;

	/** 菜单图标 */
	private String icon;

	/**
	 * 类型 0 菜单 1 按钮
	 * {@link org.general.system.common.constants.PermissionType }
	 * */
	private Integer type;

	/** 前端权限 */
	private String router;

	/** 后端权限 */
	private String permission;

}
