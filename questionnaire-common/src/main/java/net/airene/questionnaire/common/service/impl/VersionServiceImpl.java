package net.airene.questionnaire.common.service.impl;

import net.airene.questionnaire.common.data.AllInOneVersion;
import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import net.airene.questionnaire.common.data.VO.VersionResponseVO;
import net.airene.questionnaire.common.service.RedisService;
import net.airene.questionnaire.common.service.VersionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiPang
 * @Desc 版本控制service
 * @date 2021年06月02日 15:05
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class VersionServiceImpl implements VersionService {

    private final AllInOneVersion allInoneVersion;

    private final RedisService redisService;

    @Override
    public VersionResponseVO getVersion(BaseRequestDTO versionRequest) {
        String code = versionRequest.getCode();
        String version = versionRequest.getVersion();
        VersionResponseVO versionResponseVO = new VersionResponseVO();
        if (!isNewVersion(Integer.parseInt(version), allInoneVersion.getUpdateVersionNum())) {
            versionResponseVO.setIsNew(0);
            //是否强制版本
            versionResponseVO.setIsForce(isUpdateVersion(Integer.parseInt(version), allInoneVersion.getUpdateVersionNum()));
            versionResponseVO.setVersionName(allInoneVersion.getNewVersionName());
            versionResponseVO.setDownloadUrl(allInoneVersion.getNewVersionPathPrefix());
            versionResponseVO.setMessage(allInoneVersion.getNewVersionMessage());
        } else {
            versionResponseVO.setIsNew(1);
            versionResponseVO.setIsForce(0);
            versionResponseVO.setVersion("");
        }
        return versionResponseVO;
    }

   /* private String getDownloadUrl(AllInOneVersion allInoneVersion, String channel) {
        StringBuilder downloadUrl = new StringBuilder();
        AllInOneDTO allInOne = redisService.getAllInOne(channel);
        downloadUrl.append(allInoneVersion.getNewVersionPathPrefix());
        downloadUrl.append(allInOne.getCode());
        downloadUrl.append("_aio_release_");
        downloadUrl.append(allInoneVersion.getNewVersionName());
        downloadUrl.append(".apk");
        return downloadUrl.toString();
    }*/

    //是否最新版本
    private boolean isNewVersion(int versionNum, int updateVersionNum) {
        return versionNum >= updateVersionNum;
    }

    //是否强制版本
    private int isUpdateVersion(int versionNum, int updateVersionNum) {
        return versionNum < updateVersionNum ? 1 : 0;
    }
}
