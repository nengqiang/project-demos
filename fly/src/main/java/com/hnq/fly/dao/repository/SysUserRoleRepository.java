package com.hnq.fly.dao.repository;

import com.hnq.fly.dao.mapper.SysUserRoleMapper;
import com.hnq.fly.dao.po.SysUserRole;
import com.hnq.fly.dao.po.SysUserRoleCriteria;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Repository
public class SysUserRoleRepository extends BaseRepository {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    public int deleteUserRoles(Long userNo) {
        SysUserRoleCriteria example = new SysUserRoleCriteria();
        example.createCriteria().andUserNoEqualTo(userNo);
        return sysUserRoleMapper.deleteByExample(example);
    }

    public int saveUserRoles(Long userNo, List<Long> roleIds) {
        int insertCount = 0;
        for (Long roleId : roleIds) {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserNo(userNo);
            userRole.setRoleId(roleId);
            insertCount += sysUserRoleMapper.insert(userRole);
        }
        return insertCount;
    }

    public int deleteUserRolesByRoleId(Long roleId) {
        SysUserRoleCriteria example = new SysUserRoleCriteria();
        example.createCriteria().andRoleIdEqualTo(roleId);
        return sysUserRoleMapper.deleteByExample(example);
    }

}
