package com.hnq.fly.dao.repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnq.fly.dao.mapper.SysRoleMapper;
import com.hnq.fly.dao.mapper.SysUserRoleMapper;
import com.hnq.fly.dao.po.SysRole;
import com.hnq.fly.dao.po.SysRoleCriteria;
import com.hnq.fly.dao.po.SysUserRole;
import com.hnq.fly.dao.po.SysUserRoleCriteria;
import com.hnq.fly.model.domain.RoleDO;
import com.hnq.fly.model.request.RolePageRequest;
import com.hnq.toolkit.util.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author henengqiang
 * @date 2020/4/24
 */
@Repository
public class SysRoleRepository extends BaseRepository {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    public int saveRole(RoleDO role) {
        SysRole sysRole = BeanUtils.convert(role, SysRole.class);
        sysRole.setId(generator.generateKey());
        return sysRoleMapper.insert(sysRole);
    }

    public RoleDO getRoleById(Long id) {
        return BeanUtils.convert(sysRoleMapper.selectByPrimaryKey(id), RoleDO.class);
    }

    public RoleDO getRoleByRoleName(String roleName) {
        SysRoleCriteria example = new SysRoleCriteria();
        example.createCriteria().andRoleNameEqualTo(roleName);
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(sysRoles)) {
            return null;
        }
        return BeanUtils.convert(sysRoles.get(0), RoleDO.class);
    }

    public long countByRoleName(String roleName) {
        SysRoleCriteria example = new SysRoleCriteria();
        if (StringUtils.isNotEmpty(roleName)) {
            example.createCriteria().andRoleNameLike("%" + roleName + "%");
        }
        return sysRoleMapper.countByExample(example);
    }

    public PageInfo<RoleDO> listRoles(RolePageRequest req) {
        SysRoleCriteria example = new SysRoleCriteria();
        if (StringUtils.isNotEmpty(req.getRoleName())) {
            example.createCriteria().andRoleNameLike("%" + req.getRoleName() + "%");
        }
        if (StringUtils.isNotBlank(req.getOrderBy())) {
            example.setOrderByClause(req.getOrderBy());
        }
        PageHelper.startPage(req.getCurrentPage(), req.getPageSize());
        return new PageInfo<>(BeanUtils.convert(sysRoleMapper.selectByExample(example), RoleDO.class));
    }

    public List<RoleDO> listRolesByUserNo(Long userNo) {
        List<Long> roleIds = listRoleIdsByUserNo(userNo);
        SysRoleCriteria example = new SysRoleCriteria();
        example.createCriteria().andIdIn(roleIds);
        return BeanUtils.convert(sysRoleMapper.selectByExample(example), RoleDO.class);
    }

    public int updateRoleById(RoleDO role) {
        return sysRoleMapper.updateByPrimaryKeySelective(BeanUtils.convert(role, SysRole.class));
    }

    public int deleteRoleById(Long roleId) {
        return sysRoleMapper.deleteByPrimaryKey(roleId);
    }

    private List<Long> listRoleIdsByUserNo(Long userNo) {
        SysUserRoleCriteria example = new SysUserRoleCriteria();
        example.createCriteria().andUserNoEqualTo(userNo);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(example);
        return sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
    }

}
