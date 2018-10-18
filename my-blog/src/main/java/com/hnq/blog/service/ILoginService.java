package com.hnq.blog.service;

import com.hnq.blog.dao.domain.User;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
public interface ILoginService {

    User findUserRolesPermissionsByName(String name);

    User regist(String userName, String password);

}
