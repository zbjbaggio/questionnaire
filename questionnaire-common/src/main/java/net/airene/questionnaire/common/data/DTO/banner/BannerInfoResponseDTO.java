package net.airene.questionnaire.common.data.DTO.banner;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc
 * @date 2021/9/8
 */
@Data
public class BannerInfoResponseDTO implements Serializable {

    private List<BannerInfoDTO> bannerList;
}
