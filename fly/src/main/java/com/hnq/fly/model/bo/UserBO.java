package com.hnq.fly.model.bo;

import com.hnq.fly.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Getter
@Setter
@ToString
public class UserBO extends BaseEntity {

    private static final long serialVersionUID = 2554045474451659931L;

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

    private List<Long> roleIds;

    public interface Status {
        String ENABLED = "ENABLED";
        String DISABLED = "DISABLED";
        String LOCKED = "LOCKED";
    }

}

