package com.hnq.fly.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnq.fly.annotation.LogAnnotation;
import com.hnq.fly.model.bo.LoginUser;
import com.hnq.fly.model.bo.PermissionBO;
import com.hnq.fly.model.vo.PermissionVO;
import com.hnq.fly.service.PermissionService;
import com.hnq.fly.util.UserUtils;
import com.hnq.toolkit.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author henengqiang
 * @date 2020/5/5
 */
@RestController
@RequestMapping("/permission")
@Slf4j
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * @return 当前登录用户拥有的权限
     */
    @GetMapping("/current")
    public List<PermissionVO> currentPermission() {
        LoginUser loginUser = UserUtils.getLoginUser();
        assert loginUser != null;
        List<PermissionBO> list = loginUser.getPermissions();
        final List<PermissionBO> permissions = list.stream()
                .filter(p -> Objects.equals(p.getType(), 1)).collect(Collectors.toList());
        // 支持多级菜单
        List<PermissionBO> firstLevel = permissions.stream()
                .filter(p -> Objects.equals(p.getParentId(), 0L)).collect(Collectors.toList());
        firstLevel.parallelStream().forEach(p -> setChild(p, permissions));
        return BeanUtils.convert(firstLevel, PermissionVO.class);
    }

    /**
     * @return 菜单列表
     */
    @GetMapping
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public List<PermissionVO> permissionsList() {
        List<PermissionBO> permissionsAll = permissionService.listAllPermissions();

        List<PermissionBO> permissions = new ArrayList<>(permissionsAll.size() * 4 / 3 + 1);
        setPermissionsList(0L, permissionsAll, permissions);
        return BeanUtils.convert(permissions, PermissionVO.class);
    }

    /**
     * @return 所有菜单
     */
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public JSONArray permissionsAll() {
        List<PermissionBO> permissionsAll = permissionService.listAllPermissions();

        JSONArray array = new JSONArray();
        setPermissionsTree(0L, permissionsAll, array);
        return array;
    }

    /**
     * @return  一级菜单
     */
    @GetMapping("/parents")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public List<PermissionVO> parentMenu() {
        return BeanUtils.convert(permissionService.listParentPermissions(), PermissionVO.class);
    }

    /**
     * 根据角色id获取权限
     */
    @GetMapping(params = "roleId")
    @PreAuthorize("hasAnyAuthority('sys:menu:query', 'sys:role:query')")
    public List<PermissionVO> listByRoleId(Long roleId) {
        return BeanUtils.convert(permissionService.listPermissionsByRoleId(roleId), PermissionVO.class);
    }

    @LogAnnotation
    @PostMapping
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public void savePermission(@RequestBody PermissionBO permission) {
        permissionService.savePermission(permission);
    }

    /**
     * 根据菜单id获取菜单
     */
    @GetMapping("/{pId}")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public PermissionVO getPermission(@PathVariable Long pId) {
        return BeanUtils.convert(permissionService.getPermissionById(pId), PermissionVO.class);
    }

    @LogAnnotation
    @PutMapping
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public void updatePermission(@RequestBody PermissionBO permission) {
        permissionService.updatePermission(permission);
    }

    /**
     * 校验权限
     */
    @GetMapping("/owns")
    public Set<String> ownsPermission() {
        LoginUser loginUser  = UserUtils.getLoginUser();
        assert loginUser != null;
        List<PermissionBO> permissions = loginUser.getPermissions();
        if (CollectionUtils.isEmpty(permissions)) {
            return Collections.emptySet();
        }

        return permissions.parallelStream().filter(p -> StringUtils.isNotEmpty(p.getPermissionName()))
                .map(PermissionBO::getPermissionName).collect(Collectors.toSet());
    }

    @LogAnnotation
    @DeleteMapping("/{pId}")
    @PreAuthorize("hasAuthority('sys:menu:del')")
    public void deletePermission(@PathVariable Long pId) {
        permissionService.deletePermission(pId);
    }

    /**
     * 菜单树
     */
    private void setPermissionsTree(Long pId, List<PermissionBO> permissionsAll, JSONArray array) {
        permissionsAll.stream().filter(p -> Objects.equals(p.getParentId(), pId)).forEach(p -> {
            JSONObject parent = (JSONObject) JSONObject.toJSON(p);
            array.add(parent);
            if (permissionsAll.stream().anyMatch(e -> Objects.equals(e.getParentId(), p.getId()))) {
                JSONArray child = new JSONArray();
                parent.put("child", child);
                setPermissionsTree(p.getId(), permissionsAll, child);
            }
        });
    }

    /**
     * 菜单列表
     */
    private void setPermissionsList(Long pId, List<PermissionBO> permissionsAll, List<PermissionBO> list) {
        permissionsAll.stream().filter(p -> Objects.equals(p.getParentId(), pId)).forEach(p -> {
            list.add(p);
            if (permissionsAll.stream().anyMatch(e -> Objects.equals(e.getParentId(), p.getId()))) {
                setPermissionsList(p.getId(), permissionsAll, list);
            }
        });
    }

    /**
     * 设置子元素
     */
    private void setChild(PermissionBO p, List<PermissionBO> permissions) {
        List<PermissionBO> children = permissions.parallelStream()
                .filter(e -> Objects.equals(e.getParentId(), p.getId())).collect(Collectors.toList());
        p.setChildren(children);
        if (CollectionUtils.isNotEmpty(children)) {
            // 递归设置子元素，支持多级菜单
            children.parallelStream().forEach(e -> setChild(e, permissions));
        }
    }

}
