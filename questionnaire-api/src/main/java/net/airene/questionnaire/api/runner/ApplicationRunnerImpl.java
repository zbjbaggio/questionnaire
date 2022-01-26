package net.airene.questionnaire.api.runner;

import net.airene.questionnaire.common.service.NationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 启动执行方法
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ApplicationRunnerImpl implements ApplicationRunner {

    private final NationInfoService nationInfoService;

    @Override
    public void run(ApplicationArguments args) {
        // 将诺一的民族表存入redis
        nationInfoService.initSaveRedis();
    }

}
