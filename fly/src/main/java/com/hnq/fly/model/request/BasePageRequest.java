package com.hnq.fly.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author henengqiang
 * @date 2020/3/18
 */
@Getter
@Setter
@ToString
public abstract class BasePageRequest implements Serializable {

    private static final long serialVersionUID = -7031783783989889292L;

    private Integer currentPage;

    private Integer pageSize;
    
    private String orderBy;

}
