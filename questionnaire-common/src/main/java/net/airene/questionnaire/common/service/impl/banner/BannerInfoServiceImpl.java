package net.airene.questionnaire.common.service.impl.banner;

import net.airene.questionnaire.common.data.DTO.banner.BannerInfoResponseDTO;
import net.airene.questionnaire.common.mapper.BannerInfoMapper;
import net.airene.questionnaire.common.service.banner.BannerInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author LiPang
 * @Desc
 * @date 2021/9/8
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BannerInfoServiceImpl implements BannerInfoService {

    private final BannerInfoMapper bannerInfoMapper;

    /**
     * 获取banner信息
     * @return
     */
    @Override
    @Cacheable(cacheNames = "banner", key="#merchId")
    public BannerInfoResponseDTO getBannerInfo(String merchId) {
        BannerInfoResponseDTO bannerInfoDTO = new BannerInfoResponseDTO();
        bannerInfoDTO.setBannerList(bannerInfoMapper.getBannerInfo(merchId));
        return bannerInfoDTO;
    }
}
