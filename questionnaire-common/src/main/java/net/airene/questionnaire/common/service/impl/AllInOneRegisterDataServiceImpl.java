package net.airene.questionnaire.common.service.impl;

import net.airene.questionnaire.common.data.DTO.AllInOneDTO;
import net.airene.questionnaire.common.data.entity.AllInOneRegisterData;
import net.airene.questionnaire.common.mapper.AllInOneRegisterDataMapper;
import net.airene.questionnaire.common.service.AllInOneRegisterDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author LiPang
 * @Desc 一体机注册用户服务层
 * @date 2021/11/16
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class AllInOneRegisterDataServiceImpl implements AllInOneRegisterDataService {

    private final AllInOneRegisterDataMapper allinoneRegisterDataMapper;

    /**
     * 记录一体机注册用户信息
     * @param phone 手机号
     */
    @Override
    public void insertAllInOneRegisterData(AllInOneDTO allInOne, String phone) {
        AllInOneRegisterData allinoneRegisterData = new AllInOneRegisterData();
        allinoneRegisterData.setCreateTime(LocalDateTime.now());
        allinoneRegisterData.setAllInOneId(allInOne.getId());
        allinoneRegisterData.setCode(allInOne.getCode());
        allinoneRegisterData.setMerchId(allInOne.getMerchId());
        allinoneRegisterData.setRegisterDate(new Date());
        allinoneRegisterData.setPhone(phone);
        allinoneRegisterDataMapper.insertAllInOneRegisterData(allinoneRegisterData);
    }
}
