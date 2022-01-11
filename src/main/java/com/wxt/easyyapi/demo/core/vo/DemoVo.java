package com.wxt.easyyapi.demo.core.vo;

import com.sun.istack.internal.NotNull;

/**
 *
 * 测试 VO
 * @author wangxt
 * @date 2021/06/01 15:41
 */
public class DemoVo {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户余额
     */
    private Double amount;

    /**
     * 用户类型
     * @see com.easyyapi.demo.domain.enumx.UserTypeEnum#type
     */
    private Integer userType;

    /**
     * 用户昵称
     * @deprecated
     */
    private String name;

    /**
     * 用户性别
     */
    @NotNull
    private Integer sex;
}
