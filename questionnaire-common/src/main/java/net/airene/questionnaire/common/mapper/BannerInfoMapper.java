package net.airene.questionnaire.common.mapper;

import net.airene.questionnaire.common.data.DTO.banner.BannerInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LiPang
 * @Desc banner数据层
 * @date 2021/9/8
 */
@Mapper
public interface BannerInfoMapper {
    /**
     * 获取banner
     */
    List<BannerInfoDTO> getBannerInfo(String merchId);
}
