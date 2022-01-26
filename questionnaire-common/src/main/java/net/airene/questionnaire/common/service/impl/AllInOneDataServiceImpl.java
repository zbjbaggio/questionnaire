package net.airene.questionnaire.common.service.impl;

import net.airene.questionnaire.common.data.DTO.AllInOneDTO;
import net.airene.questionnaire.common.data.DTO.guest.TakeUpTimeDTO;
import net.airene.questionnaire.common.data.entity.AllInOneData;
import net.airene.questionnaire.common.mapper.AllInOneDataMapper;
import net.airene.questionnaire.common.service.AllInOneDataService;
import net.airene.questionnaire.common.util.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * 一体机数据 服务层实现
 *
 * @author YANQING
 * @date 2021-08-30
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AllInOneDataServiceImpl implements AllInOneDataService {

    private final AllInOneDataMapper allInOneDataMapper;

    @Override
    public void recordData(AllInOneDTO allInOne, TakeUpTimeDTO takeUpTimeDTO) throws ParseException {
        AllInOneData allInOneData = new AllInOneData();
        BeanUtils.copyProperties(takeUpTimeDTO, allInOneData);
        allInOneData.setCreateTime(LocalDateTime.now());
        allInOneData.setAllInOneId(allInOne.getId());
        allInOneData.setStayDateCount(DateUtils.between(allInOneData.getRsvDepDate(), allInOneData.getRsvArrDate(), Calendar.DATE));
        allInOneDataMapper.insertAllInOneData(allInOneData);
    }

}
