package com.hnq.fly.model.bo;

import com.hnq.fly.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Getter
@Setter
@ToString
public class SysLogBO extends BaseEntity {

    private static final long serialVersionUID = -4729149902684043091L;

    private Long userNo;

    private String module;

    private String result;

    private String remark;

    public interface Status {
        String SUCCESS = "SUCCESS";
        String FAILED = "FAILED";
    }

}
