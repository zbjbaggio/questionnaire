package net.airene.questionnaire.common.service;

import net.airene.questionnaire.common.data.entity.NationInfo;
import java.util.List;
import java.util.Map;

/**
 * 民族 服务层
 *
 * @author YANQING
 * @date 2021-08-27
 */
public interface NationInfoService {
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
     * 修改民族
     *
     * @param nationInfo 民族信息
     * @return 结果
     */
	int updateNationInfo(NationInfo nationInfo);

	/**
     * 删除民族信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteNationInfoByIds(Long[] ids);

	Map<String, String> initSaveRedis();
}
