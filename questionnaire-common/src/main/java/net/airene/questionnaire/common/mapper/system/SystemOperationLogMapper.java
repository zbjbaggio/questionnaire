package net.airene.questionnaire.common.mapper.system;

import net.airene.questionnaire.common.data.entity.system.SystemOperationLog;

import java.util.List;

/**
 * 后台系统操作记录 数据层
 *
 * @author eason
 * @date 2020-09-04
 */
public interface SystemOperationLogMapper {
	/**
     * 查询后台系统操作记录信息
     *
     * @param id 后台系统操作记录ID
     * @return 后台系统操作记录信息
     */
	SystemOperationLog getSystemOperationLogById(Long id);

	/**
     * 查询后台系统操作记录列表
     *
     * @param systemOperationLog 后台系统操作记录信息
     * @return 后台系统操作记录集合
     */
	List<SystemOperationLog> selectSystemOperationLogList(SystemOperationLog systemOperationLog);

	/**
     * 新增后台系统操作记录
     *
     * @param systemOperationLog 后台系统操作记录信息
     * @return 结果
     */
	int insertSystemOperationLog(SystemOperationLog systemOperationLog);

	/**
	 * 批量新增后台系统操作记录
	 *
	 * @param systemOperationLogList 后台系统操作记录信息
	 * @return 结果
	 */
	int batchInsertSystemOperationLog(List<SystemOperationLog> systemOperationLogList);

	/**
     * 修改后台系统操作记录
     *
     * @param systemOperationLog 后台系统操作记录信息
     * @return 结果
     */
	int updateSystemOperationLog(SystemOperationLog systemOperationLog);

	/**
     * 删除后台系统操作记录
     *
     * @param id 后台系统操作记录ID
     * @return 结果
     */
	int deleteSystemOperationLogById(Long id);

	/**
     * 批量删除后台系统操作记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteSystemOperationLogByIds(Long[] ids);

}
