package net.airene.questionnaire.common.service;

import net.airene.questionnaire.common.data.DTO.AllInOneDTO;
import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import net.airene.questionnaire.common.data.DTO.LoginDTO;
import net.airene.questionnaire.common.data.entity.AllInOneInfo;
import java.util.List;

/**
 * 一体机 服务层
 *
 * @author YANQING
 * @date 2021-06-01
 */
public interface AllInOneInfoService {
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
     * 修改一体机
     *
     * @param allInOneInfo 一体机信息
     * @return 结果
     */
	int updateAllInOneInfo(AllInOneInfo allInOneInfo);

	/**
     * 删除一体机信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteAllInOneInfoByIds(Long[] ids);

    AllInOneDTO getAllInOneInfoByCode(String code);
    
    LoginDTO login(BaseRequestDTO baseRequestDTO);

}
