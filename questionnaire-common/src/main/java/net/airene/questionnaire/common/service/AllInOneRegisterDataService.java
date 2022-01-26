package net.airene.questionnaire.common.service;

import net.airene.questionnaire.common.data.DTO.AllInOneDTO;

/**
 * @author LiPang
 * @Desc 一体机注册用户服务层
 * @date 2021/11/16
 */
public interface AllInOneRegisterDataService {

    void insertAllInOneRegisterData(AllInOneDTO allInOne, String phone);
}
