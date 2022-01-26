package net.airene.questionnaire.admin.controller.advice.system;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.common.controller.BaseController;
import net.airene.questionnaire.common.data.VO.system.PermissionVO;
import net.airene.questionnaire.common.service.system.SystemPermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单管理
 */
@RestController
@Slf4j
@RequestMapping("/user/system/permission")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PermissionController extends BaseController {

    private final SystemPermissionService systemPermissionService;

    /**
     * 查询所有的角色，用于用户选择角色使用
     * @return
     */
    @RequiresPermissions(value = {"system:role:list"})
    @GetMapping(value = "/listAll")
    public List<PermissionVO> listAll() {
        return systemPermissionService.selectSystemPermissionListAll();
    }

}
