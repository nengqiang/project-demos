package com.hnq.fly.model.bo;

import com.hnq.fly.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author henengqiang
 * @date 2020/4/24
 */
@Getter
@Setter
@ToString
public class RoleBO extends BaseEntity {

    private static final long serialVersionUID = 5832051486147001687L;

    private String roleName;

    private String description;

    private List<Long> permissionIds;

}
