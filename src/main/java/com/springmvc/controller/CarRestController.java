package com.springmvc.controller;

import com.springmvc.pojo.CustomType;
import com.springmvc.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/car")
public class CarRestController {
    @Resource(name = "carService")
    private CarService carService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(HttpServletRequest request,
            @RequestParam("img") MultipartFile img) throws IOException {
        System.out.println("进来了");
        System.out.println(img);
        // 原始名称
        String initImgName = img.getOriginalFilename();
        // 上传图片
        if (img != null && initImgName != null && initImgName.length() > 0) {
            // 存储图片的物理路径
            System.out.println(request.getContextPath());
            // 获得项目的绝对路径
            String destPath = request.getServletContext().getRealPath("upload/");
            // 新的图片名称
            String newImgPath = UUID.randomUUID() + initImgName.substring(initImgName.lastIndexOf("."));
            // 新图片
            File newFile = new File(destPath + newImgPath);
            if(!newFile.exists()){
                newFile.mkdirs();
            }
            System.out.println(newFile.getAbsolutePath());
            // 将内存中的数据写入磁盘
            img.transferTo(newFile);
        }
        return new ResponseEntity<>(new CustomType(400, "新增失败！"), HttpStatus.OK);
    }
}
