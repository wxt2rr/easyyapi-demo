package com.wxt.easyyapi.demo.core.controller;

import com.wxt.easyyapi.demo.core.vo.DemoVo;
import com.wxt.easyyapi.demo.core.vo.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试分类4
 * 这是一个测试类哦~
 * @module easyyapi-demo
 * @author wangxt
 * @date 2021/06/01 15:11
 */
@RequestMapping("/demo/")
@RestController
public class DemoController {

    /**
     * demoMethod
     * 这是一个测试方法哦~
     * @param userId 用户ID
     * @param name 用户昵称
     * @param userType 用户类型 {@link com.wxt.easyyapi.demo.core.enumx.UserTypeEnum}
     * @author wangxt
     * @date 2021/6/1 0001 15:53
     * @return {@link DemoVo}
     */
    @RequestMapping("demoMethod.do")
    @ResponseBody
    private ServerResponse<DemoVo> demoMethod(@RequestParam(required = true) Integer userId,
                                              @RequestParam(required = false, defaultValue = "") String name,
                                              @RequestParam(value = "user_type", required = false, defaultValue = "1") Integer userType){
        return ServerResponse.createBySuccess(new DemoVo());
    }
}
