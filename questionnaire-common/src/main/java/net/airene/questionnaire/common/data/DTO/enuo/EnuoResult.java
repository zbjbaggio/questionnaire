package net.airene.questionnaire.common.data.DTO.enuo;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "YN365JDB")
@ToString
@Getter
public class EnuoResult {

    public String checkResult;

    @XmlElement
    private Head HEAD;

    @XmlElement
    private Content CONTENT;

    @ToString
    @Getter
    public static class Head {

        @XmlElement
        private String REPLYCODE;

        @XmlElement
        private String MESSAGE;
    }

    @ToString
    @Getter
    public static class Content {

        @XmlElement
        private String DBJG;
    }
}
