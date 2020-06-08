package com.hnq.fly.dao.repository;

import com.google.common.collect.Lists;
import com.hnq.fly.dao.mapper.SysPermissionMapper;
import com.hnq.fly.dao.mapper.SysRolePermissionMapper;
import com.hnq.fly.dao.mapper.SysUserRoleMapper;
import com.hnq.fly.dao.po.*;
import com.hnq.fly.model.domain.PermissionDO;
import com.hnq.toolkit.util.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author henengqiang
 * @date 2020/4/26
 */
@Repository
public class SysPermissionRepository extends BaseRepository {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    public List<PermissionDO> listAllPermissions() {
        SysPermissionCriteria example = new SysPermissionCriteria();
        example.setOrderByClause("sort");
        return BeanUtils.convert(sysPermissionMapper.selectByExample(example), PermissionDO.class);
    }

    public List<PermissionDO> listParentPermissions() {
        SysPermissionCriteria example = new SysPermissionCriteria();
        example.createCriteria().andTypeEqualTo(Byte.valueOf("1"));
        example.setOrderByClause("sort");
        return BeanUtils.convert(sysPermissionMapper.selectByExample(example), PermissionDO.class);
    }

    public List<PermissionDO> listPermissionsByUserNo(Long userNo) {
        List<Long> roleIds = listRoleIdsByUserNo(userNo);
        List<Long> permissionIds = listPermissionIdsByRoleIds(roleIds);

        SysPermissionCriteria example = new SysPermissionCriteria();
        example.createCriteria().andIdIn(permissionIds);
        example.setOrderByClause("sort");
        return BeanUtils.convert(sysPermissionMapper.selectByExample(example), PermissionDO.class);
    }

    public List<PermissionDO> listPermissionsByRoleId(Long roleId) {
        List<Long> permissionIds = listPermissionIdsByRoleIds(Lists.newArrayList(roleId));

        SysPermissionCriteria example = new SysPermissionCriteria();
        example.createCriteria().andIdIn(permissionIds);
        example.setOrderByClause("sort");
        return BeanUtils.convert(sysPermissionMapper.selectByExample(example), PermissionDO.class);
    }

    public PermissionDO getPermissionById(Long permissionId) {
        return BeanUtils.convert(sysPermissionMapper.selectByPrimaryKey(permissionId), PermissionDO.class);
    }

    public int savePermission(PermissionDO permission) {
        SysPermission sysPermission = BeanUtils.convert(permission, SysPermission.class);
        sysPermission.setId(generator.generateKey());
        return sysPermissionMapper.insert(sysPermission);
    }

    public int updatePermissionById(PermissionDO permission) {
        SysPermission sysPermission = BeanUtils.convert(permission, SysPermission.class);
        return sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
    }

    public int deletePermissionById(Long permissionId) {
        return sysPermissionMapper.deleteByPrimaryKey(permissionId);
    }

    public int deletePermissionByParentId(Long parentId) {
        SysPermissionCriteria example = new SysPermissionCriteria();
        example.createCriteria().andParentIdEqualTo(parentId);
        return sysPermissionMapper.deleteByExample(example);
    }

    public Set<Long> listUserNosByPermissionId(Long permissionId) {
        List<Long> roleIds = listRoleIdsByPermissionId(permissionId);
        return new HashSet<>(listUserNosByRoleIds(roleIds));
    }

    private List<Long> listUserNosByRoleIds(List<Long> roleIds) {
        SysUserRoleCriteria example = new SysUserRoleCriteria();
        example.createCriteria().andRoleIdIn(roleIds);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(example);
        return sysUserRoles.stream().map(SysUserRole::getUserNo).collect(Collectors.toList());
    }

    private List<Long> listRoleIdsByPermissionId(Long permissionId) {
        SysRolePermissionCriteria example = new SysRolePermissionCriteria();
        example.createCriteria().andPermissionIdEqualTo(permissionId);
        List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByExample(example);
        return sysRolePermissions.stream().map(SysRolePermission::getRoleId).collect(Collectors.toList());
    }

    private List<Long> listPermissionIdsByRoleIds(List<Long> roleIds) {
        SysRolePermissionCriteria example = new SysRolePermissionCriteria();
        example.createCriteria().andRoleIdIn(roleIds);
        List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByExample(example);
        return sysRolePermissions.stream().map(SysRolePermission::getPermissionId).collect(Collectors.toList());
    }

    private List<Long> listRoleIdsByUserNo(Long userNo) {
        SysUserRoleCriteria example = new SysUserRoleCriteria();
        example.createCriteria().andUserNoEqualTo(userNo);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(example);
        return sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
    }

}
