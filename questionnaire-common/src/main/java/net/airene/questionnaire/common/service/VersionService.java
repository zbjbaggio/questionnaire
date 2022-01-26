package net.airene.questionnaire.common.service;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import net.airene.questionnaire.common.data.VO.VersionResponseVO;

/**
 * @author LiPang
 * @Desc 版本控制service
 * @date 2021年06月02日 15:01
 */
public interface VersionService {

    VersionResponseVO getVersion(BaseRequestDTO versionRequest);
}
