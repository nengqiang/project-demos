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
public class SysLogVO implements Serializable {

    private static final long serialVersionUID = 8235534140206460378L;

    private Long userNo;

    private String module;

    private String result;

    private String remark;

}
