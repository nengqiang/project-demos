package com.hnq.fly.model.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Restful 方式登陆 token
 *
 * @author henengqiang
 * @date 2020/3/16
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Token implements Serializable {

    private static final long serialVersionUID = 7195695077772049071L;

    private String token;

    private Long loginTime;

}
