package com.hnq.fly.service.impl;

import com.github.pagehelper.PageInfo;
import com.hnq.fly.dao.repository.SysRolePermissionRepository;
import com.hnq.fly.dao.repository.SysRoleRepository;
import com.hnq.fly.dao.repository.SysUserRoleRepository;
import com.hnq.fly.model.bo.RoleBO;
import com.hnq.fly.model.domain.RoleDO;
import com.hnq.fly.model.request.RolePageRequest;
import com.hnq.fly.model.response.PageDataResponse;
import com.hnq.fly.service.RoleService;
import com.hnq.toolkit.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author henengqiang
 * @date 2020/4/26
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleRepository roleRepository;

    @Autowired
    private SysUserRoleRepository userRoleRepository;

    @Autowired
    private SysRolePermissionRepository rolePermissionRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRole(RoleBO role) {
        List<Long> permissionIds = role.getPermissionIds();
        if (permissionIds != null) {
            permissionIds.remove(0L);
        }

        if (role.getId() != null) {
            updateRole(role, permissionIds);
        } else {
            saveRole(role, permissionIds);
        }
    }

    @Override
    public RoleBO getRoleByRoleId(Long roleId) {
        return BeanUtils.convert(roleRepository.getRoleById(roleId), RoleBO.class);
    }

    @Override
    public List<RoleBO> listRoleByUserNo(Long userNo) {
        return BeanUtils.convert(roleRepository.listRolesByUserNo(userNo), RoleBO.class);
    }

    @Override
    public PageDataResponse<RoleBO> listRoles(RolePageRequest request) {
        PageInfo<RoleDO> data = roleRepository.listRoles(request);
        return new PageDataResponse<>(data.getTotal(), BeanUtils.convert(data.getList(), RoleBO.class));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteRole(Long roleId) {
        rolePermissionRepository.deleteRolePermissionsByRoleId(roleId);
        userRoleRepository.deleteUserRolesByRoleId(roleId);
        roleRepository.deleteRoleById(roleId);

        log.debug("删除角色id={}", roleId);
    }

    private void saveRole(RoleBO role, List<Long> permissionIds) {
        RoleDO r = roleRepository.getRoleByRoleName(role.getRoleName());
        if (r != null && !r.getId().equals(role.getId())) {
            throw new IllegalArgumentException(role.getRoleName() + "已存在");
        }

        roleRepository.saveRole(BeanUtils.convert(role, RoleDO.class));
        if (CollectionUtils.isNotEmpty(permissionIds)) {
            rolePermissionRepository.saveRolePermissions(role.getId(), permissionIds);
        }
        log.debug("新增角色{}", role.getRoleName());
    }

    private void updateRole(RoleBO role, List<Long> permissionIds) {
        RoleDO r = roleRepository.getRoleByRoleName(role.getRoleName());
        if (r != null && !r.getId().equals(role.getId())) {
            throw new IllegalArgumentException(role.getRoleName() + "已存在");
        }

        roleRepository.updateRoleById(BeanUtils.convert(role, RoleDO.class));

        rolePermissionRepository.deleteRolePermissionsByRoleId(role.getId());
        if (CollectionUtils.isNotEmpty(permissionIds)) {
            rolePermissionRepository.saveRolePermissions(role.getId(), permissionIds);
        }
        log.debug("修改角色{}", role.getRoleName());
    }

}
