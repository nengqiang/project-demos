package com.hnq.fly.model.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageDataResponse<T> implements Serializable {

    private static final long serialVersionUID = -479927070131149088L;

    private Long total;

    private List<T> data;

}
