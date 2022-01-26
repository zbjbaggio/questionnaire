package net.airene.questionnaire.common.data;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@NacosConfigurationProperties(prefix = "all-in-one-version", dataId = "allinone", autoRefreshed = true, type = ConfigType.YAML )
public class AllInOneVersion {

    private Integer newVersionNum;

    private String newVersionName;

    private Integer updateVersionNum;

    private String newVersionPathPrefix;

    private String newVersionMessage;
}
