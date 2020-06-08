package com.hnq.fly.controller;

import com.hnq.fly.annotation.LogAnnotation;
import com.hnq.fly.model.bo.RoleBO;
import com.hnq.fly.model.request.RolePageRequest;
import com.hnq.fly.model.response.PageDataResponse;
import com.hnq.fly.model.vo.RoleVO;
import com.hnq.fly.service.RoleService;
import com.hnq.toolkit.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色相关接口
 *
 * @author henengqiang
 * @date 2020/4/27
 */
@RestController
@RequestMapping("/roles")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    @LogAnnotation
    @PostMapping
    @PreAuthorize("hasAnyAuthority('sys:role:add')")
    public void saveRole(@RequestBody RoleBO role) {
        roleService.saveRole(role);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('sys:role:query')")
    public PageDataResponse<RoleVO> listRoles(RolePageRequest request) {
        PageDataResponse<RoleBO> data = roleService.listRoles(request);
        return new PageDataResponse<>(data.getTotal(), BeanUtils.convert(data.getData(), RoleVO.class));
    }

    @GetMapping("/{roleId}")
    @PreAuthorize("hasAuthority('sys:role:query')")
    public RoleVO getRole(@PathVariable Long roleId) {
        return BeanUtils.convert(roleService.getRoleByRoleId(roleId), RoleVO.class);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('sys:user:query', 'sys:role:query')")
    public List<RoleVO> roles() {
        return BeanUtils.convert(roleService.listRoles(new RolePageRequest()).getData(), RoleVO.class);
    }

    @GetMapping(params = "userNo")
    @PreAuthorize("hasAnyAuthority('sys:user:query', 'sys:role:query')")
    public List<RoleVO> roles(Long userNo) {
        return BeanUtils.convert(roleService.listRoleByUserNo(userNo), RoleVO.class);
    }

    @LogAnnotation
    @DeleteMapping("/{roleId}")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    public void deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
    }

}
