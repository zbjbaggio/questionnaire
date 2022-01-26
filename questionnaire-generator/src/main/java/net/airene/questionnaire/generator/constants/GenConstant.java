package net.airene.questionnaire.generator.constants;

import net.airene.questionnaire.generator.domain.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "gen")
@Component
@PropertySource(value = "classpath:generator.yml", factory = YamlPropertySourceFactory.class)
@Data
public class GenConstant {

    private String author;

    /** 生成包路径 */
    private String packageName;

    private String commonPackageName;

    private String controllerPackageName;

    /** 生成包路径 */
    private String moduleName;

    /**
     * 公共工程名
     */
    private String publicProjectModuleName;

    /** 自动去除表前缀，默认是true */
    private String autoRemovePrefix;

    /** 表前缀(类名不会包含表前缀) */
    private String tablePrefix;

}

