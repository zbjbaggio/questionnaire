package net.airene.questionnaire.api.controller.advice;

import net.airene.questionnaire.common.data.DTO.AllInOneDTO;
import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import net.airene.questionnaire.common.data.DTO.banner.BannerInfoResponseDTO;
import net.airene.questionnaire.common.service.RedisService;
import net.airene.questionnaire.common.service.banner.BannerInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiPang
 * @Desc banner控制类
 * @date 2021/9/8
 */
@Slf4j
@RestController
@RequestMapping("/banner")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BannerController {

    private final BannerInfoService bannerInfoService;

    private final RedisService redisService;

    /**
     * 获取banner图
     *
     * @param baseRequestDTO
     * @return
     */
    @PostMapping("/getBanner")
    public BannerInfoResponseDTO getBannerInfo(@RequestBody @Validated BaseRequestDTO baseRequestDTO) {
        AllInOneDTO allInOne = redisService.getAllInOne(baseRequestDTO.getCode());
        return bannerInfoService.getBannerInfo(allInOne.getMerchId());
    }

}