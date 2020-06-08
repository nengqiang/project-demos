package com.hnq.fly.dao.repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnq.fly.dao.mapper.SysUserMapper;
import com.hnq.fly.dao.mapper.ext.SysUserExtMapper;
import com.hnq.fly.dao.po.SysUser;
import com.hnq.fly.dao.po.SysUserCriteria;
import com.hnq.fly.model.domain.UserDO;
import com.hnq.fly.model.request.UserPageRequest;
import com.hnq.toolkit.util.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Repository
public class SysUserRepository extends BaseRepository {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserExtMapper sysUserExtMapper;

    public int saveUser(UserDO user) {
        SysUser sysUser = BeanUtils.convert(user, SysUser.class);
        sysUser.setUserNo(generator.generateKey());
        return sysUserMapper.insert(sysUser);
    }

    public UserDO getUserByNo(Long userNo) {
        SysUserCriteria example = new SysUserCriteria();
        example.createCriteria().andUserNoEqualTo(userNo);
        List<SysUser> users = sysUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return BeanUtils.convert(users.get(0), UserDO.class);
    }

    public UserDO getUserByName(String username) {
        SysUserCriteria example = new SysUserCriteria();
        example.createCriteria().andUsernameEqualTo(username);
        List<SysUser> users = sysUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return BeanUtils.convert(users.get(0), UserDO.class);
    }

    public int changePassword(Long userNo, String newPwd) {
        SysUserCriteria example = new SysUserCriteria();
        example.createCriteria().andUserNoEqualTo(userNo);
        SysUser user = new SysUser();
        user.setPassword(newPwd);
        return sysUserMapper.updateByExampleSelective(user, example);
    }

    public long countByNameAndStatus(UserPageRequest req) {
        SysUserCriteria example = buildQuery(req);
        return sysUserMapper.countByExample(example);
    }

    public PageInfo<UserDO> listUsers(UserPageRequest req) {
        SysUserCriteria example = buildQuery(req);
        PageHelper.startPage(req.getCurrentPage(), req.getPageSize());
        return new PageInfo<>(BeanUtils.convert(sysUserMapper.selectByExample(example), UserDO.class));
    }

    public int updateUserByUserNo(UserDO user) {
        SysUser sysUser = BeanUtils.convert(user, SysUser.class);
        SysUserCriteria example = new SysUserCriteria();
        example.createCriteria().andUserNoEqualTo(user.getUserNo());
        return sysUserMapper.updateByExampleSelective(sysUser, example);
    }

    private SysUserCriteria buildQuery(UserPageRequest req) {
        SysUserCriteria example = new SysUserCriteria();
        SysUserCriteria.Criteria criteria = example.createCriteria();
        // 支持模糊查询
        if (StringUtils.isNotEmpty(req.getUsername())) {
            criteria.andUsernameEqualTo("%" + req.getUsername() + "%");
        }
        if (StringUtils.isNotEmpty(req.getNickname())) {
            criteria.andNicknameEqualTo("%" + req.getNickname() + "%");
        }
        if (StringUtils.isNotEmpty(req.getStatus())) {
            criteria.andStatusEqualTo(req.getStatus());
        }
        if (StringUtils.isNotBlank(req.getOrderBy())) {
            example.setOrderByClause(req.getOrderBy());
        }
        return example;
    }

}
