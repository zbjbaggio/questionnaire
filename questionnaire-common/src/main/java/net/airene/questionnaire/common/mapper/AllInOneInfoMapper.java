package net.airene.questionnaire.common.mapper;

import net.airene.questionnaire.common.data.DTO.AllInOneDTO;
import net.airene.questionnaire.common.data.entity.AllInOneInfo;
import java.util.List;

/**
 * 一体机 数据层
 *
 * @author YANQING
 * @date 2021-06-01
 */
public interface AllInOneInfoMapper {
	/**
     * 查询一体机信息
     *
     * @param id 一体机ID
     * @return 一体机信息
     */
	AllInOneInfo getAllInOneInfoById(Long id);

	/**
     * 查询一体机列表
     *
     * @param allInOneInfo 一体机信息
     * @return 一体机集合
     */
	List<AllInOneInfo> listAllInOneInfo(AllInOneInfo allInOneInfo);

	/**
     * 新增一体机
     *
     * @param allInOneInfo 一体机信息
     * @return 结果
     */
	int insertAllInOneInfo(AllInOneInfo allInOneInfo);

	/**
	 * 批量新增一体机
	 *
	 * @param allInOneInfoList 一体机信息
	 * @return 结果
	 */
	int batchInsertAllInOneInfo(List<AllInOneInfo> allInOneInfoList);

	/**
     * 修改一体机
     *
     * @param allInOneInfo 一体机信息
     * @return 结果
     */
	int updateAllInOneInfo(AllInOneInfo allInOneInfo);

	/**
     * 删除一体机
     *
     * @param id 一体机ID
     * @return 结果
     */
	int deleteAllInOneInfoById(Long id);

	/**
     * 批量删除一体机
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteAllInOneInfoByIds(Long[] ids);

    AllInOneDTO getAllInOneInfoByCode(String code);

    List<AllInOneDTO> listAll();

    AllInOneDTO getByCode(String code);
}
