package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Package: com.itheima.config
 * @Author: PengSS
 * @Date: 2018/9/16 14:19
 *
 * SpringMvc的配置类
 */
//扫描控制层，只扫面Controller
@ComponentScan(value = "com.itheima", includeFilters ={
        @ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
})
public class SpringMvcConfig {

    /**
     * @Author 传智吴彦祖
     * @Date 2018/9/16 14:20
     * 配置springmvc的视图解析器
     */
    @Bean
    public InternalResourceViewResolver createInternalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
       //文件所在的路径
        internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
        //文件的后缀名
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
