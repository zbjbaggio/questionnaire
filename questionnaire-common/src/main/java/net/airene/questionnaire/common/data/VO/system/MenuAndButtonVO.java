package net.airene.questionnaire.common.data.VO.system;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * 描述：菜单和按钮集合
 * Created by jay on 2017-12-14.
 */
@Data
public class MenuAndButtonVO {

    private Set<String> permissionSet;

    private List<PermissionVO> routers;

    private Set<String> buttonSet;
}
