package com.hnq.fly.service.impl;

import com.github.pagehelper.PageInfo;
import com.hnq.fly.dao.repository.SysUserRepository;
import com.hnq.fly.dao.repository.SysUserRoleRepository;
import com.hnq.fly.model.bo.UserBO;
import com.hnq.fly.model.domain.UserDO;
import com.hnq.fly.model.request.UserPageRequest;
import com.hnq.fly.model.response.PageDataResponse;
import com.hnq.fly.service.UserService;
import com.hnq.toolkit.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserRepository userRepository;

    @Autowired
    private SysUserRoleRepository userRoleRepository;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserBO saveUser(UserBO u) {
        UserDO user = BeanUtils.convert(u, UserDO.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(UserBO.Status.ENABLED);
        userRepository.saveUser(user);
        saveUserRoles(user.getUserNo(), u.getRoleIds());

        log.debug("新增用户{}", user.getUsername());
        return u;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserBO updateUser(UserBO u) {
        UserDO user = BeanUtils.convert(u, UserDO.class);
        userRepository.updateUserByUserNo(user);
        saveUserRoles(user.getUserNo(), u.getRoleIds());
        return u;
    }

    @Override
    public UserBO getUserByUsername(String username) {
        return BeanUtils.convert(userRepository.getUserByName(username), UserBO.class);
    }

    @Override
    public UserBO getUserByUserNo(Long userNo) {
        return BeanUtils.convert(userRepository.getUserByNo(userNo), UserBO.class);
    }

    @Override
    public PageDataResponse<UserBO> listUsers(UserPageRequest request) {
        PageInfo<UserDO> pageInfo = userRepository.listUsers(request);
        return new PageDataResponse<>(pageInfo.getTotal(), BeanUtils.convert(pageInfo.getList(), UserBO.class));
    }

    @Override
    public void changePassword(String username, String oldPwd, String newPwd) {
        UserDO user = userRepository.getUserByName(username);
        if (user == null) {
            throw new IllegalArgumentException("用户不存在");
        }

        if (!passwordEncoder.matches(oldPwd, user.getPassword())) {
            throw new IllegalArgumentException("旧密码错误");
        }

        userRepository.changePassword(user.getUserNo(), passwordEncoder.encode(newPwd));
        log.debug("修改{}的密码", username);
    }

    private void saveUserRoles(Long userNo, List<Long> roleIds) {
        if (roleIds != null) {
            userRoleRepository.deleteUserRoles(userNo);
            if (CollectionUtils.isNotEmpty(roleIds)) {
                userRoleRepository.saveUserRoles(userNo, roleIds);
            }
        }
    }

}
