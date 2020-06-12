package com.hnq.fly.service;

import com.hnq.fly.model.bo.PermissionBO;

import java.util.List;

/**
 * @author henengqiang
 * @date 2020/4/26
 */
public interface PermissionService {

    void savePermission(PermissionBO permission);

    void updatePermission(PermissionBO permission);

    void deletePermission(Long permissionId);

    PermissionBO getPermissionById(Long id);

    List<PermissionBO> listPermissionsByRoleId(Long roleId);

    List<PermissionBO> listPermissionsByUserNo(Long userNo);

    List<PermissionBO> listAllPermissions();

    List<PermissionBO> listParentPermissions();
}
