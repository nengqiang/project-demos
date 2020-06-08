package com.hnq.fly.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResponseInfo implements Serializable {

    private static final long serialVersionUID = -5410470053443497102L;

    private String code;

    private String message;

}
