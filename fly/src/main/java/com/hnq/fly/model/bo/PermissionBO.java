package com.hnq.fly.model.bo;

import com.hnq.fly.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Getter
@Setter
@ToString
public class PermissionBO extends BaseEntity {

    private static final long serialVersionUID = -5981247149460284791L;

    private Long parentId;

    private String menuName;

    private Byte type;

    private String permissionName;

    private Integer sort;

    private List<PermissionBO> children;

}
