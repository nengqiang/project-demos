package com.hnq.fly.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author henengqiang
 * @date 2020/4/27
 */
@Getter
@Setter
@ToString
public class UserVO implements Serializable {

    private static final long serialVersionUID = 8349329779813359573L;

    private Long userNo;

    private String username;

    private String password;

    private String nickname;

    private String headImgUrl;

    private String phone;

    private String email;

    @JsonFormat(pattern = "yyy-MM-dd")
    private Date birthday;

    private String sex;

    private String status;

}
