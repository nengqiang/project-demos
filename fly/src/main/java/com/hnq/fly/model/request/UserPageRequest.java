package com.hnq.fly.model.request;

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
public class UserPageRequest extends BasePageRequest {

    private static final long serialVersionUID = 3608973239847338165L;

    private String username;

    private String nickname;

    private String status;

}
