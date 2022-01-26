package net.airene.questionnaire.api.controller.advice;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import net.airene.questionnaire.common.data.VO.VersionResponseVO;
import net.airene.questionnaire.common.service.VersionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class VersionController {

    private final VersionService versionService;

    @PostMapping("/getDetail")
    public VersionResponseVO getDetail(@RequestBody BaseRequestDTO versionRequest) {
        return versionService.getVersion(versionRequest);
    }

}
