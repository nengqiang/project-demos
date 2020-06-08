package com.hnq.fly.enums;

import lombok.Getter;

/**
 * 模块枚举
 *
 * @author henengqiang
 * @date 2020/4/23
 */
@Getter
public enum ModuleEnum {

    /**
     * 登录模块
     */
    LOGIN("登录"),

    /**
     * 登出模块
     */
    EXIT("退出");

    /**
     * 模块中文描述
     */
    private final String zhDesc;

    ModuleEnum(String zhDesc) {
        this.zhDesc = zhDesc;
    }

}
