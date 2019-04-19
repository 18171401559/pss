package com.itheima.controller;

import com.itheima.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @Package: com.itheima.controller
 * @Author: PengSS
 * @Date: 2018/9/15 1:49
 */
@Controller
public class HelloSpringMVC {
    /**
     * @Author 传智吴彦祖
     * @Param
     * @Return
     * @Date 2018/9/15 1:49
     */
    /**
     * @Author 传智吴彦祖
     * @Date 2018/9/15 1:52
     * springmvc的入门程序
     */
    @RequestMapping("/hello")
    public String sayHello(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/upload1")
    public String upload1(HttpServletRequest request) throws Exception {
        //获取项目中存放文件的绝对路径
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        //判断该路径的文件夹是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取文件的上传项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            //判断该项是文件上传项还是普通项
            if (item.isFormField()) {
                //普通表单项
            } else {
                //说明是上传项，获取上传的文件名
                String fileName = item.getName();
                String s = UUID.randomUUID().toString();
                System.out.println(path + s + fileName);
                //完成文件的上传
                item.write(new File(path, s + fileName));
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/upload2")
    public String upload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        //获取项目中存放文件的绝对路径
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        //判断该路径的文件夹是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = upload.getOriginalFilename();
        String s = UUID.randomUUID().toString();
        upload.transferTo(new File(path, s + fileName));
        return "success";
    }

    /**
     * 跨域上传图片
     *
     * @Author 传智吴彦祖
     * @Date 2018/9/15 20:06
     */
    @RequestMapping("/upload3")
    public String upload3(MultipartFile upload) throws Exception {
        //定义图片服务器的请求路径
        String path = "http://localhost:8081/upload/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        String s = UUID.randomUUID().toString().replace("-", "");

        //创建客户端对象
        Client client = Client.create();
        WebResource resource = client.resource(path + s + "_" + fileName);

        resource.put(upload.getBytes());

        return "success";
    }
}
