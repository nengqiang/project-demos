package com.hnq.fly.model.domain;

import com.hnq.fly.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author henengqiang
 * @date 2020/4/27
 */
@Getter
@Setter
@ToString
public class RoleDO extends BaseEntity {

    private static final long serialVersionUID = 3322439899072988732L;

    private String roleName;

    private String description;

}
