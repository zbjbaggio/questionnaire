package net.airene.questionnaire.common.data.VO.system;

import lombok.Data;

import java.util.List;

/**
 * 描述：
 * Created by jay on 2017-12-13.
 */
@Data
public class PermissionVO {

    private Long id;

    private Long parentId;

    private int type;

    private String permission;

    private String icon;

    private String path;

    private String component;

    private String redirect;

    private String alwaysShow;

    private String name;

    private String roleId;

    List<PermissionVO> children;

    //List<PermissionVO> button;
}
