package net.airene.questionnaire.common.data.DTO.guest;

import lombok.Data;

import java.io.Serializable;

@Data
public class Photos implements Serializable {
    /**
     * 现场照片
     */
    private String photo;

    /**
     * 证件照片
     */
    private String idPhoto;
}
