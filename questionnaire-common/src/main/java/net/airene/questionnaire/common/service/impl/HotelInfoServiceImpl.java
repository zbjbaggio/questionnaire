package net.airene.questionnaire.common.service.impl;

import net.airene.questionnaire.common.data.entity.HotelInfo;
import net.airene.questionnaire.common.mapper.HotelInfoMapper;
import net.airene.questionnaire.common.service.HotelInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 酒店 服务层实现
 *
 * @author YANQING
 * @date 2021-06-01
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
// TODO 最后没用删掉
public class HotelInfoServiceImpl implements HotelInfoService {

	private final HotelInfoMapper hotelInfoMapper;

	/**
     * 查询酒店信息
     *
     * @param id 酒店ID
     * @return 酒店信息
     */
    @Override
	@Cacheable(cacheNames = {"hotelInfo"})
	public HotelInfo getHotelInfoById(Long id) {
	    return hotelInfoMapper.getHotelInfoById(id);
	}

	/**
     * 查询酒店列表
     *
     * @param hotelInfo 酒店信息
     * @return 酒店集合
     */
	@Override
	public List<HotelInfo> listHotelInfo(HotelInfo hotelInfo) {
	    return hotelInfoMapper.listHotelInfo(hotelInfo);
	}

    /**
     * 新增酒店
     *
     * @param hotelInfo 酒店信息
     * @return 结果
     */
	@Override
	public int insertHotelInfo(HotelInfo hotelInfo) {
	    return hotelInfoMapper.insertHotelInfo(hotelInfo);
	}

	/**
     * 修改酒店
     *
     * @param hotelInfo 酒店信息
     * @return 结果
     */
	@Override
	public int updateHotelInfo(HotelInfo hotelInfo) {
	    return hotelInfoMapper.updateHotelInfo(hotelInfo);
	}

	/**
     * 删除酒店对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHotelInfoByIds(Long[] ids) {
		return hotelInfoMapper.deleteHotelInfoByIds(ids);
	}

	@Override
	@Transactional
	public void test() throws Exception {
		HotelInfoServiceImpl o =(HotelInfoServiceImpl)AopContext.currentProxy();
		o.test1();
		o.test3();
		o.test2();
		/*test1();
		test2();*/
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void test1() {
		HotelInfo hotelInfo = new HotelInfo();
		hotelInfo.setCreateTime(LocalDateTime.now());
		hotelInfo.setCode("1111");
		hotelInfo.setName("2222222222");
		hotelInfoMapper.insertHotelInfo(hotelInfo);
	}

	@Transactional
	public void test3() {
		HotelInfo hotelInfo = new HotelInfo();
		hotelInfo.setCreateTime(LocalDateTime.now());
		hotelInfo.setCode("2222");
		hotelInfo.setName("3333333");
		hotelInfoMapper.insertHotelInfo(hotelInfo);
	}

	@Transactional
	public void test2() {
		throw new RuntimeException("");
	}

}
