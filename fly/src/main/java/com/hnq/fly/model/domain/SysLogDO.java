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
public class SysLogDO extends BaseEntity {

    private static final long serialVersionUID = 6941936045044430455L;

    private Long userNo;

    private String module;

    private String result;

    private String remark;

}
