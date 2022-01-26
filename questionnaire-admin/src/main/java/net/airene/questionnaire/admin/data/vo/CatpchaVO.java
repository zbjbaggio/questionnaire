package net.airene.questionnaire.admin.data.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"captcha"})
public class CatpchaVO {

    private String token;

    private String captcha;

}
