package net.airene.questionnaire.common.mapper;

import net.airene.questionnaire.common.data.entity.NationInfo;
import java.util.List;

/**
 * 民族 数据层
 *
 * @author YANQING
 * @date 2021-08-27
 */
public interface NationInfoMapper {
	/**
     * 查询民族信息
     *
     * @param id 民族ID
     * @return 民族信息
     */
	NationInfo getNationInfoById(Long id);

	/**
     * 查询民族列表
     *
     * @param nationInfo 民族信息
     * @return 民族集合
     */
	List<NationInfo> listNationInfo(NationInfo nationInfo);

	/**
     * 新增民族
     *
     * @param nationInfo 民族信息
     * @return 结果
     */
	int insertNationInfo(NationInfo nationInfo);

	/**
	 * 批量新增民族
	 *
	 * @param nationInfoList 民族信息
	 * @return 结果
	 */
	int batchInsertNationInfo(List<NationInfo> nationInfoList);

	/**
     * 修改民族
     *
     * @param nationInfo 民族信息
     * @return 结果
     */
	int updateNationInfo(NationInfo nationInfo);

	/**
     * 删除民族
     *
     * @param id 民族ID
     * @return 结果
     */
	int deleteNationInfoById(Long id);

	/**
     * 批量删除民族
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteNationInfoByIds(Long[] ids);

}
