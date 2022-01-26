package net.airene.questionnaire.common.service.impl;

import net.airene.questionnaire.common.data.entity.NationInfo;
import net.airene.questionnaire.common.enums.NationTypeEnum;
import net.airene.questionnaire.common.mapper.NationInfoMapper;
import net.airene.questionnaire.common.service.NationInfoService;
import net.airene.questionnaire.common.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 民族 服务层实现
 *
 * @author YANQING
 * @date 2021-08-27
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class NationInfoServiceImpl implements NationInfoService {

	private final NationInfoMapper nationInfoMapper;

	private final RedisService redisService;

	/**
     * 查询民族信息
     *
     * @param id 民族ID
     * @return 民族信息
     */
    @Override
	public NationInfo getNationInfoById(Long id) {
	    return nationInfoMapper.getNationInfoById(id);
	}

	/**
     * 查询民族列表
     *
     * @param nationInfo 民族信息
     * @return 民族集合
     */
	@Override
	public List<NationInfo> listNationInfo(NationInfo nationInfo) {
	    return nationInfoMapper.listNationInfo(nationInfo);
	}

    /**
     * 新增民族
     *
     * @param nationInfo 民族信息
     * @return 结果
     */
	@Override
	public int insertNationInfo(NationInfo nationInfo) {
	    return nationInfoMapper.insertNationInfo(nationInfo);
	}

	/**
     * 修改民族
     *
     * @param nationInfo 民族信息
     * @return 结果
     */
	@Override
	public int updateNationInfo(NationInfo nationInfo) {
	    return nationInfoMapper.updateNationInfo(nationInfo);
	}

	/**
     * 删除民族对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteNationInfoByIds(Long[] ids) {
		return nationInfoMapper.deleteNationInfoByIds(ids);
	}

	/**
	 * 启动时存入redis
	 */
	@Override
	public Map<String, String> initSaveRedis() {
		NationInfo param = new NationInfo();
		param.setType(NationTypeEnum.ENUO.getValue());
		List<NationInfo> nationInfos = nationInfoMapper.listNationInfo(param);
		Map<String, String> collect = nationInfos.stream().collect(Collectors.toMap(NationInfo::getName, (nationInfo -> nationInfo.getCode())));
		redisService.saveNationList(collect);
		return collect;
	}

}
