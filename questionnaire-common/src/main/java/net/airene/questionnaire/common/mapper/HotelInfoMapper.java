package net.airene.questionnaire.common.mapper;

import net.airene.questionnaire.common.data.entity.HotelInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 酒店 数据层
 *
 * @author YANQING
 * @date 2021-06-01
 */
@Mapper
public interface HotelInfoMapper {
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
	 * 批量新增酒店
	 *
	 * @param hotelInfoList 酒店信息
	 * @return 结果
	 */
	int batchInsertHotelInfo(List<HotelInfo> hotelInfoList);

	/**
     * 修改酒店
     *
     * @param hotelInfo 酒店信息
     * @return 结果
     */
	int updateHotelInfo(HotelInfo hotelInfo);

	/**
     * 删除酒店
     *
     * @param id 酒店ID
     * @return 结果
     */
	int deleteHotelInfoById(Long id);

	/**
     * 批量删除酒店
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteHotelInfoByIds(Long[] ids);

}
