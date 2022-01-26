package net.airene.questionnaire.common.service;

import net.airene.questionnaire.common.data.DTO.AllInOneDTO;
import net.airene.questionnaire.common.data.VO.system.SystemUserVO;

import java.util.Map;

public interface RedisService {

    void saveAllInOne(AllInOneDTO allInOneDTO);

    AllInOneDTO getAllInOne(String code);

    void saveNationList(Map<String, String> collect);

    String getNation(String keyValue);

    void saveLvPMSSessionId(String value);

    String getLvPMSSessionId(String key);

    void saveCaptcha(String captcha, String value);

    void saveSystemLogin(SystemUserVO login);

    SystemUserVO getSystemLogin(Long userId);

    void deletePermission(Long userId);

    void reExpireSystemLogin(SystemUserVO login);

    String getCaptcha(String captcha);

    void deleteCaptcha(String captcha);

    void deleteSystemLogin(Long userId);
}
