package com.itheima.controller;

import com.itheima.domain.Items;
import com.itheima.service.ItemService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Package: com.itheima.contrallor
 * @Author: PengSS
 * @Date: 2018/9/18 23:35
 */
@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/editItems")
    public ModelAndView  save(int id){
        ModelAndView modelAndView = new ModelAndView();
        Items items = itemService.findById(id);
        modelAndView.addObject("items",items);
        modelAndView.setViewName("editItems");
        return modelAndView;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("itemsList");
        List<Items>  list =itemService.findAll();
        modelAndView.addObject("itemsList",list);
        return  modelAndView;
    }


    @RequestMapping("/updateItems")
    public ModelAndView updateItems(HttpServletRequest request,MultipartFile upload) throws Exception {
        //获取项目中存放文件的绝对路径
        String path = request.getSession().getServletContext().getRealPath("/pic/");
        //判断该路径的文件夹是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = upload.getOriginalFilename();
        System.out.println(fileName);
        upload.transferTo(new File(path,fileName));
        Map parameterMap = request.getParameterMap();
        Items items = new Items();
        org.apache.commons.beanutils.BeanUtils.populate(items,parameterMap);
        ModelAndView modelAndView = new ModelAndView();
        items.setPic(fileName);
        itemService.update(items);
        List<Items>  list =itemService.findAll();
        modelAndView.setViewName("itemsList");
        modelAndView.addObject("itemsList",list);
        return modelAndView;
    }
}
