package net.airene.questionnaire.common.service.banner;

import net.airene.questionnaire.common.data.DTO.banner.BannerInfoResponseDTO;


/**
 * @author LiPang
 * @Desc banner服务类
 * @date 2021/9/8
 */
public interface BannerInfoService {

    BannerInfoResponseDTO getBannerInfo(String merchId);
}
