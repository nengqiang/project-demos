package com.hnq.fly.dao.repository;

import com.hnq.fly.dao.mapper.SysRolePermissionMapper;
import com.hnq.fly.dao.po.SysRolePermission;
import com.hnq.fly.dao.po.SysRolePermissionCriteria;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author henengqiang
 * @date 2020/4/26
 */
@Repository
public class SysRolePermissionRepository extends BaseRepository {

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    public void saveRolePermissions(Long roleId, List<Long> permissionIds) {
        for (Long permissionId : permissionIds) {
            SysRolePermission rolePermission = new SysRolePermission();
            rolePermission.setId(generator.generateKey());
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            Date date = new Date();
            rolePermission.setCreateTime(date);
            rolePermission.setUpdateTime(date);
            sysRolePermissionMapper.insert(rolePermission);
        }
    }

    public int deleteRolePermissionsByRoleId(Long roleId) {
        SysRolePermissionCriteria example = new SysRolePermissionCriteria();
        example.createCriteria().andRoleIdEqualTo(roleId);
        return sysRolePermissionMapper.deleteByExample(example);
    }

    public int deleteRolePermissionsByPermissionId(Long permissionId) {
        SysRolePermissionCriteria example = new SysRolePermissionCriteria();
        example.createCriteria().andPermissionIdEqualTo(permissionId);
        return sysRolePermissionMapper.deleteByExample(example);
    }

}
