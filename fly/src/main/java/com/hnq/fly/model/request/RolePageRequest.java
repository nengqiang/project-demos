package com.hnq.fly.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author henengqiang
 * @date 2020/4/24
 */
@Getter
@Setter
@ToString
public class RolePageRequest extends BasePageRequest {

    private static final long serialVersionUID = -696999339979526564L;

    private String roleName;

}
