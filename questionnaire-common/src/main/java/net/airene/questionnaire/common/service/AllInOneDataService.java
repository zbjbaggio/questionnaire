package net.airene.questionnaire.common.service;

import net.airene.questionnaire.common.data.DTO.guest.TakeUpTimeDTO;
import net.airene.questionnaire.common.data.DTO.AllInOneDTO;

import java.text.ParseException;

/**
 * 酒店数据 服务层
 *
 * @author YANQING
 * @date 2021-08-30
 */
public interface AllInOneDataService {

	void recordData(AllInOneDTO allInOne, TakeUpTimeDTO takeUpTimeDTO) throws ParseException;
}
