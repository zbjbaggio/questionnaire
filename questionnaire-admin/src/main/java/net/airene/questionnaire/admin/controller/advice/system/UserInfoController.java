package net.airene.questionnaire.admin.controller.advice.system;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.admin.utils.ValueHolder;
import net.airene.questionnaire.common.data.VO.system.SystemUserVO;
import net.airene.questionnaire.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user/my")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserInfoController {

    private final ValueHolder valueHolder;

    private final RedisService redisService;

    @GetMapping(value = "/getInfo")
    public SystemUserVO getInfo() {
       return redisService.getSystemLogin(valueHolder.getUserIdHolder());
    }

}
