package net.airene.questionnaire.api.controller.advice;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import net.airene.questionnaire.common.data.DTO.LoginDTO;
import net.airene.questionnaire.common.service.AllInOneInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LoginController {

    private final AllInOneInfoService allInOneInfoService;

    @PostMapping
    public LoginDTO login(@RequestBody BaseRequestDTO baseRequestDTO) {
       return allInOneInfoService.login(baseRequestDTO);
    }

}
