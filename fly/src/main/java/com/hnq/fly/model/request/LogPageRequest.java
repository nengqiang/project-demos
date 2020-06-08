package com.hnq.fly.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author henengqiang
 * @date 2020/3/18
 */
@Getter
@Setter
@ToString
public class LogPageRequest extends BasePageRequest {

    private static final long serialVersionUID = -6783348157856877414L;

    private String result;

    private String nickname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
