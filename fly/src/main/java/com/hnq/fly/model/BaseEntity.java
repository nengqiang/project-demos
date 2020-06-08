package com.hnq.fly.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Getter
@Setter
@ToString
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 4861156953051330317L;

    private Long id;

    private Date createTime = new Date();

    private Date updateTime = new Date();

}
