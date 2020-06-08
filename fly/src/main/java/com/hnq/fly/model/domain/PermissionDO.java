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
public class PermissionDO extends BaseEntity {

    private static final long serialVersionUID = 623817193733533602L;

    private Long parentId;

    private String menuName;

    private Byte type;

    private String permissionName;

    private Integer sort;

}
