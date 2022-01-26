package net.airene.questionnaire.admin.controller.advice.system;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.admin.annotation.LogRecord;
import net.airene.questionnaire.common.constant.system.SystemUserStatusConstant;
import net.airene.questionnaire.common.controller.BaseController;
import net.airene.questionnaire.common.data.DTO.system.SystemUserRoleDTO;
import net.airene.questionnaire.common.data.PrivateException;
import net.airene.questionnaire.common.data.VO.system.SystemUserRoleVO;
import net.airene.questionnaire.common.data.entity.system.SystemUser;
import net.airene.questionnaire.common.data.page.TableDataInfo;
import net.airene.questionnaire.common.enums.ErrorInfoEnum;
import net.airene.questionnaire.common.service.system.SystemUserService;
import net.airene.questionnaire.generator.utils.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user/system/user")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController extends BaseController {

    private final SystemUserService systemUserService;

    /**
     * 系统用户查询
     * @param username 用户名
     * @param status 状态
     * @return 系统用户列表
     */
    @RequiresPermissions("system:user:list")
    @GetMapping(value = "/list")
    public TableDataInfo list(@RequestParam(defaultValue = "") String username,
                              @RequestParam(defaultValue = "") String phone,
                              @RequestParam(defaultValue = "") String realName,
                              @RequestParam(defaultValue = "") String company,
                              @RequestParam(defaultValue = "") Integer status,
                              @RequestParam(defaultValue = "1") int pageNumber,
                              @RequestParam(defaultValue = "10") int pageSize) {
        startPage();
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(username);
        systemUser.setPhone(phone);
        systemUser.setRealName(realName);
        systemUser.setCompany(company);
        systemUser.setStatus(status);
        return getDataTable(systemUserService.selectSystemUserList(systemUser));
    }

    /**
     * 添加管理员
     *
     * @param systemUserRoleDTO 用户角色对象
     */
    @LogRecord("系统用户保存")
    @RequiresPermissions("system:user:list")
    @PostMapping(value = "/save")
    public void save(@RequestBody @Validated(value = {SystemUserRoleDTO.Save.class}) SystemUserRoleDTO systemUserRoleDTO) {
        if (systemUserRoleDTO.getSystemUser().getId() == null && StringUtil.isEmpty(systemUserRoleDTO.getSystemUser().getPassword())) {
            throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
        }
        systemUserService.save(systemUserRoleDTO);
    }

    /**
     * 系统用户详情
     *
     * @param userId 系统用户id
     * @return 系统用户详情
     */
    @RequiresPermissions("system:user:list")
    @GetMapping(value = "/getDetail/{userId}")
    public SystemUserRoleVO getDetail(@PathVariable("userId") Long userId) {
        return systemUserService.selectSystemUserById(userId);
    }

    /**
     * 系统用户冻结
     *
     * @param userId 用户id
     */
    @LogRecord("系统用户禁用")
    @RequiresPermissions("system:user:list")
    @PostMapping(value = "/freeze/{userId}")
    public void freeze(@PathVariable Long userId) {
        systemUserService.updateStatus(userId, SystemUserStatusConstant.FREEZE);
    }

    /**
     * 系统用户解冻
     *
     * @param userId 用户id
     */
    @RequiresPermissions("system:user:list")
    @LogRecord("系统用户启用")
    @PostMapping(value = "/unFreeze/{userId}")
    public void unFreeze(@PathVariable Long userId) {
        systemUserService.updateStatus(userId, SystemUserStatusConstant.UNFREEZE);
    }

}
