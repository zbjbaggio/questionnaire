package net.airene.questionnaire.common.service;

import net.airene.questionnaire.common.data.entity.HotelInfo;
import java.util.List;

/**
 * 酒店 服务层
 *
 * @author YANQING
 * @date 2021-06-01
 */
public interface HotelInfoService {
	/**
     * 查询酒店信息
     *
     * @param id 酒店ID
     * @return 酒店信息
     */
	HotelInfo getHotelInfoById(Long id);

	/**
     * 查询酒店列表
     *
     * @param hotelInfo 酒店信息
     * @return 酒店集合
     */
	List<HotelInfo> listHotelInfo(HotelInfo hotelInfo);

	/**
     * 新增酒店
     *
     * @param hotelInfo 酒店信息
     * @return 结果
     */
	int insertHotelInfo(HotelInfo hotelInfo);

	/**
     * 修改酒店
     *
     * @param hotelInfo 酒店信息
     * @return 结果
     */
	int updateHotelInfo(HotelInfo hotelInfo);

	/**
     * 删除酒店信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteHotelInfoByIds(Long[] ids);

    void test() throws Exception;
    
}
