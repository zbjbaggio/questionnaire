package net.airene.questionnaire.admin.controller.advice.system;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.admin.annotation.LogRecord;
import net.airene.questionnaire.admin.utils.ValueHolder;
import net.airene.questionnaire.common.constant.system.SystemRoleStatusConstant;
import net.airene.questionnaire.common.controller.BaseController;
import net.airene.questionnaire.common.data.DTO.system.SystemRoleDTO;
import net.airene.questionnaire.common.data.DTO.system.SystemRolePermissionDTO;
import net.airene.questionnaire.common.data.DTO.system.SystemRoleUserDTO;
import net.airene.questionnaire.common.data.DTO.system.UserQueryDTO;
import net.airene.questionnaire.common.data.VO.system.RoleVO;
import net.airene.questionnaire.common.data.VO.system.UserRoleIdVO;
import net.airene.questionnaire.common.data.entity.system.SystemRole;
import net.airene.questionnaire.common.data.entity.system.SystemUser;
import net.airene.questionnaire.common.data.page.TableDataInfo;
import net.airene.questionnaire.common.service.system.SystemRoleService;
import net.airene.questionnaire.common.service.system.SystemUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述：角色管理控制类
 * Created by jay on 2017-10-12.
 */
@RestController
@Slf4j
@RequestMapping("/user/system/role")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RoleController extends BaseController {

    private final SystemRoleService systemRoleService;

    private final ValueHolder valueHolder;

    private final SystemUserService systemUserService;

    /**
     * 查询所有的角色，用于用户选择角色使用
     *
     * @return 角色
     */
    @RequiresPermissions(value = {"system:user:list"})
    @GetMapping(value = "/listAll")
    public List<SystemRole> listAll() {
        return systemRoleService.selectSystemRoleListAll();
    }

    /**
     * 角色查询
     *
     * @param pageNumber 页数
     * @param pageSize 页大小
     * @param name 名字
     * @param status 状态
     * @return 分页
     */
    @GetMapping(value = "/list")
    @RequiresPermissions("system:role:list")
    public TableDataInfo list(@RequestParam(defaultValue = "1") int pageNumber,
                              @RequestParam(defaultValue = "10") int pageSize,
                              @RequestParam(value = "name", defaultValue = "") String name,
                              @RequestParam(value = "status", defaultValue = "") Integer status,
                              @RequestParam(value = "creatorName", defaultValue = "") String creatorName) {
        startPage();
        SystemRoleDTO systemRoleDTO = new SystemRoleDTO();
        systemRoleDTO.setName(name);
        systemRoleDTO.setStatus(status);
        systemRoleDTO.setCreatorName(creatorName);
        return getDataTable(systemRoleService.selectSystemRoleList(systemRoleDTO));
    }

    /**
     * 保存
     *
     * @param systemRolePermissionDTO 角色菜单对象
     */
    @LogRecord("系统角色管理保存")
    @RequiresPermissions("system:role:list")
    @PostMapping(value = "/save")
    public void save(@RequestBody @Validated(SystemRolePermissionDTO.Save.class) SystemRolePermissionDTO systemRolePermissionDTO) {
        systemRolePermissionDTO.getSystemRole().setCreatorId(valueHolder.getUserIdHolder());
        systemRoleService.save(systemRolePermissionDTO);
    }

    /**
     * 详情
     *
     * @param roleId 角色id
     * @return 角色和权限
     */
    @RequiresPermissions("system:role:list")
    @GetMapping(value = "/getDetail/{roleId}")
    public RoleVO getDetail(@PathVariable Long roleId) {
        return systemRoleService.getDetail(roleId);
    }

    /**
     * 冻结
     *
     * @param roleId 角色id
     */
    @LogRecord("系统角色管理禁用")
    @RequiresPermissions("system:role:list")
    @PostMapping(value = "/freeze/{roleId}")
    public void freeze(@PathVariable Long roleId) {
        systemRoleService.updateStatus(roleId, SystemRoleStatusConstant.FREEZE);
    }

    /**
     * 系统角色解冻
     *
     * @param roleId 角色id
     */
    //@RequiresPermissions("system:user:unFreeze")
    @LogRecord("系统角色管理启用")
    @RequiresPermissions("system:role:list")
    @PostMapping(value = "/unFreeze/{roleId}")
    public void unFreeze(@PathVariable Long roleId) {
        systemRoleService.updateStatus(roleId, SystemRoleStatusConstant.UNFREEZE);
    }

    /**
     * 删除
     *
     * @param roleId 角色id
     */
    @LogRecord("系统角色管理删除")
    @RequiresPermissions("system:role:list")
    @PostMapping(value = "/delete/{roleId}")
    public void delete(@PathVariable Long roleId) {
        systemRoleService.delete(roleId);
    }

    /**
     * 查询所有用户信息，如果有角色的roleId有值
     * @param roleId 角色id
     * @return 用户角色list
     */
    @RequiresPermissions("system:role:list")
    @GetMapping(value = "/userList/{roleId}")
    public List<UserRoleIdVO> userList(@PathVariable Long roleId,
                                       @RequestParam(defaultValue = "") String username,
                                       @RequestParam(defaultValue = "") String phone,
                                       @RequestParam(defaultValue = "") String realName,
                                       @RequestParam(defaultValue = "") String company,
                                       @RequestParam(defaultValue = "") Integer status) {
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setRoleId(roleId);
        userQueryDTO.setUsername(username);
        userQueryDTO.setRealName(realName);
        userQueryDTO.setCompany(company);
        userQueryDTO.setStatus(status);
        userQueryDTO.setPhone(phone);
        return systemUserService.selectSystemUserAllList(userQueryDTO);
    }

    /**
     * 查询该角色有的用户信息
     * @param roleId 角色id
     * @return 用户信息
     */
    @RequiresPermissions("system:role:list")
    @GetMapping(value = "/listHasUserList/{roleId}")
    public List<SystemUser> listHasUserList(@PathVariable Long roleId) {
        return systemUserService.listHasUserList(roleId);
    }

    @LogRecord("管理系统角色管理用户")
    @RequiresPermissions("system:role:list")
    @PostMapping(value = "/saveUserList")
    public void saveUsers(@RequestBody @Validated SystemRoleUserDTO systemRoleUserDTO) {
        systemUserService.saveUsers(systemRoleUserDTO);
    }

}
