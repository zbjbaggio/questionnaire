package net.airene.questionnaire.common.data.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRequestDTO implements Serializable {

    /**
     * 一体机设备号
     */
    private String code;

    /**
     * 一体机版本
     */
    private String version;

    /**
     * 后端API版本
     */
    private String apiVersion;

}
