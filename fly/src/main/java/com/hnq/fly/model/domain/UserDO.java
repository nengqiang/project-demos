package com.hnq.fly.model.domain;

import com.hnq.fly.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author henengqiang
 * @date 2020/4/27
 */
@Getter
@Setter
@ToString
public class UserDO extends BaseEntity {

    private static final long serialVersionUID = -2181867603944491484L;

    private Long userNo;

    private String username;

    private String password;

    private String nickname;

    private String headImgUrl;

    private String phone;

    private String email;

    private Date birthday;

    private String sex;

    private String status;

}
