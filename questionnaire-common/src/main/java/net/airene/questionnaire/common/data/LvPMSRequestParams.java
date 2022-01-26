package net.airene.questionnaire.common.data;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author LiPang
 * @Desc 绿云请求接口常量
 * @date 2021年08月27日 17:01
 */
@Data
@Component
@NacosConfigurationProperties(prefix = "lvpms-request-params", dataId = "allinone", autoRefreshed = true, type = ConfigType.YAML )
public class LvPMSRequestParams {

    private String appKey;

    private String appSercret;

    private String usercode;

    private String password;

    private String version;

    private String local;

    private String sessionUrl;

    private String baseUrl;

    private String hotelGroupCode;
}
