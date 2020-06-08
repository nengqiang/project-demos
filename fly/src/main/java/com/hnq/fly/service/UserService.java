package com.hnq.fly.service;

import com.hnq.fly.model.bo.UserBO;
import com.hnq.fly.model.request.UserPageRequest;
import com.hnq.fly.model.response.PageDataResponse;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
public interface UserService {

    UserBO saveUser(UserBO user);

    UserBO updateUser(UserBO user);

    UserBO getUserByUsername(String username);

    UserBO getUserByUserNo(Long userNo);

    PageDataResponse<UserBO> listUsers(UserPageRequest request);

    void changePassword(String username, String oldPwd, String newPwd);

}
