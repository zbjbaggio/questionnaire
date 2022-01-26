package net.airene.questionnaire.common.service.impl;

import net.airene.questionnaire.common.data.DTO.AllInOneDTO;
import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import net.airene.questionnaire.common.data.DTO.LoginDTO;
import net.airene.questionnaire.common.data.PrivateException;
import net.airene.questionnaire.common.data.VO.VersionResponseVO;
import net.airene.questionnaire.common.data.entity.AllInOneInfo;
import net.airene.questionnaire.common.enums.ErrorInfoEnum;
import net.airene.questionnaire.common.mapper.AllInOneInfoMapper;
import net.airene.questionnaire.common.service.AllInOneInfoService;
import net.airene.questionnaire.common.service.RedisService;
import net.airene.questionnaire.common.service.VersionService;
import net.airene.questionnaire.common.util.JwtUtil;
import net.airene.questionnaire.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 一体机 服务层实现
 *
 * @author YANQING
 * @date 2021-06-01
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AllInOneInfoServiceImpl implements AllInOneInfoService {

    private final AllInOneInfoMapper allInOneInfoMapper;

    private final RedisService redisService;

    private final VersionService versionService;

    private final JwtUtil jwtUtil;

    /**
     * 查询一体机信息
     *
     * @param id 一体机ID
     * @return 一体机信息
     */
    @Override
    public AllInOneInfo getAllInOneInfoById(Long id) {
        return allInOneInfoMapper.getAllInOneInfoById(id);
    }

    /**
     * 查询一体机列表
     *
     * @param allInOneInfo 一体机信息
     * @return 一体机集合
     */
    @Override
    public List<AllInOneInfo> listAllInOneInfo(AllInOneInfo allInOneInfo) {
        return allInOneInfoMapper.listAllInOneInfo(allInOneInfo);
    }

    /**
     * 新增一体机
     *
     * @param allInOneInfo 一体机信息
     * @return 结果
     */
    @Override
    public int insertAllInOneInfo(AllInOneInfo allInOneInfo) {
        return allInOneInfoMapper.insertAllInOneInfo(allInOneInfo);
    }

    /**
     * 修改一体机
     *
     * @param allInOneInfo 一体机信息
     * @return 结果
     */
    @Override
    public int updateAllInOneInfo(AllInOneInfo allInOneInfo) {
        return allInOneInfoMapper.updateAllInOneInfo(allInOneInfo);
    }

    /**
     * 删除一体机对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAllInOneInfoByIds(Long[] ids) {
        return allInOneInfoMapper.deleteAllInOneInfoByIds(ids);
    }

    @Override
    public AllInOneDTO getAllInOneInfoByCode(String code) {
        return allInOneInfoMapper.getAllInOneInfoByCode(code);
    }

    /**
     * 根据设备id登录
     * 如果没有查到设备，插入设备id
     * 如果查到设备，返回相关信息
     *
     * @param baseRequestDTO
     * @return
     */
    @Override
    public LoginDTO login(BaseRequestDTO baseRequestDTO) {
        AllInOneDTO allInOneDTO = allInOneInfoMapper.getByCode(baseRequestDTO.getCode());
        if (Objects.isNull(allInOneDTO)) {
            createAllInfoOne(baseRequestDTO.getCode());
        }
        if (Objects.isNull(allInOneDTO) || StringUtils.isEmpty(allInOneDTO.getMerchId())) {
            throw new PrivateException(ErrorInfoEnum.ALL_IN_ONE_UNUSED_ERROR);
        }
        String token = jwtUtil.sign(allInOneDTO.getCode());
        allInOneDTO.setToken(token);
        redisService.saveAllInOne(allInOneDTO);
        VersionResponseVO version = versionService.getVersion(baseRequestDTO);
        return new LoginDTO(token, version);
    }

    @Transactional
    public void createAllInfoOne(String code) {
        AllInOneInfo allInOneInfo = new AllInOneInfo();
        allInOneInfo.setCode(code);
        allInOneInfo.setCreateTime(LocalDateTime.now());
        allInOneInfoMapper.insertAllInOneInfo(allInOneInfo);
    }

}
