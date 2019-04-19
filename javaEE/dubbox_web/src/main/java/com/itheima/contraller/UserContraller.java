package com.itheima.contraller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.itheima.contraller
 * @Author: PengSS
 * @Date: 2018/9/16 17:26
 */
@Controller
public class UserContraller {

    //引用dubbox的服务
    @Reference
    private UserService userService;

    @RequestMapping("hello")
    @ResponseBody
    public String getName(){
        String name = userService.getName();
        System.out.println(name);
        return name;
    }
}
