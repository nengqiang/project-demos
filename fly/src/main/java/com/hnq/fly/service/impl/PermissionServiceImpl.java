package com.hnq.fly.service.impl;

import com.hnq.fly.model.bo.PermissionBO;
import com.hnq.fly.dao.repository.SysPermissionRepository;
import com.hnq.fly.dao.repository.SysRolePermissionRepository;
import com.hnq.fly.model.domain.PermissionDO;
import com.hnq.fly.service.PermissionService;
import com.hnq.toolkit.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
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
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysPermissionRepository permissionRepository;

    @Autowired
    private SysRolePermissionRepository rolePermissionRepository;

    @Override
    public void savePermission(PermissionBO permission) {
        permissionRepository.savePermission(BeanUtils.convert(permission, PermissionDO.class));

        log.debug("新增菜单{}", permission.getMenuName());
    }

    @Override
    public void updatePermission(PermissionBO permission) {
        permissionRepository.updatePermissionById(BeanUtils.convert(permission, PermissionDO.class));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deletePermission(Long permissionId) {
        rolePermissionRepository.deleteRolePermissionsByPermissionId(permissionId);
        permissionRepository.deletePermissionById(permissionId);
        permissionRepository.deletePermissionByParentId(permissionId);

        log.debug("删除菜单id={}", permissionId);
    }

    @Override
    public PermissionBO getPermissionById(Long id) {
        return BeanUtils.convert(permissionRepository.getPermissionById(id), PermissionBO.class);
    }

    @Override
    public List<PermissionBO> listPermissionsByRoleId(Long roleId) {
        return BeanUtils.convert(permissionRepository.listPermissionsByRoleId(roleId), PermissionBO.class);
    }

    @Override
    public List<PermissionBO> listPermissionsByUserNo(Long userNo) {
        return BeanUtils.convert(permissionRepository.listPermissionsByUserNo(userNo), PermissionBO.class);
    }

    @Override
    public List<PermissionBO> listAllPermissions() {
        return BeanUtils.convert(permissionRepository.listAllPermissions(), PermissionBO.class);
    }

    @Override
    public List<PermissionBO> listParentPermissions() {
        return BeanUtils.convert(permissionRepository.listParentPermissions(), PermissionBO.class);
    }

}
