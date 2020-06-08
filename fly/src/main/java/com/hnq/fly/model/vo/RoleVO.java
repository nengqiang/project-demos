package com.hnq.fly.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author henengqiang
 * @date 2020/4/27
 */
@Getter
@Setter
@ToString
public class RoleVO implements Serializable {

    private static final long serialVersionUID = -5184218425043492378L;

    private String roleName;

    private String description;

}
