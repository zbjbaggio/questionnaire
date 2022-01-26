package net.airene.questionnaire.common.data.VO;

import lombok.Data;
import lombok.ToString;

/**
 * @author LiPang
 * @Desc
 * @date 2021年06月02日 16:49
 */
@Data
@ToString(exclude = {"message"})
public class VersionResponseVO {
    /**
     * 是否最新版本(1 最新 0 不是最新)
     */
    private Integer isNew;

    /**
     * 是否强更(1 强更 0 不强更)
     */
    private Integer isForce;

    /**
     * 版本号
     */
    private String version;

    /**
     * 版本名
     */
    private String versionName;

    /**
     * 下载路径
     */
    private String downloadUrl;

    /**
     * 版本信息
     */
    private String message;
}
