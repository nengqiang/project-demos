package com.hnq.fly.service;

import com.hnq.fly.model.bo.RoleBO;
import com.hnq.fly.model.request.RolePageRequest;
import com.hnq.fly.model.response.PageDataResponse;

import java.util.List;

/**
 * @author henengqiang
 * @date 2020/4/26
 */
public interface RoleService {

    void saveRole(RoleBO role);

    RoleBO getRoleByRoleId(Long roleId);

    List<RoleBO> listRoleByUserNo(Long userNo);

    PageDataResponse<RoleBO> listRoles(RolePageRequest request);

    void deleteRole(Long roleId);

}
