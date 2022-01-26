package net.airene.questionnaire.api.controller.advice;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkToken")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CheckTokenController {

    /**
     * 没有逻辑只将token延续半个小时
     * @param baseRequestDTO
     */
    @PostMapping
    public void checkToken(@RequestBody BaseRequestDTO baseRequestDTO) {
    }
}
