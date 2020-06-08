package com.hnq.fly.model.vo;

import com.hnq.fly.model.bo.PermissionBO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author henengqiang
 * @date 2020/4/27
 */
@Getter
@Setter
@ToString
public class PermissionVO implements Serializable {

    private static final long serialVersionUID = -187150897216655759L;

    private Long parentId;

    private String menuName;

    private Byte type;

    private String permissionName;

    private Integer sort;

    private List<PermissionBO> children;

}
