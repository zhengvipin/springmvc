package com.springmvc.controller;

import com.springmvc.pojo.Car;
import com.springmvc.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static java.io.File.separatorChar;


@Controller
public class UploadController {

    @Resource(name = "carService")
    private CarService carService;

    /**
     * 进入indexUI
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index", "car", carService.find(15));
    }

    /**
     * 单个图片上传
     *
     * @param request
     * @param id         小汽车id
     * @param singleFile 上传图片
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/single_upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         Integer id,
                         MultipartFile singleFile) throws IOException {
        if (!singleFile.isEmpty()) {
            // 图片存储绝对路径
            String savePath = "F:\\pic";
            // 原图片名称
            String initName = singleFile.getOriginalFilename();
            // 新图片名称
            String newName = UUID.randomUUID() + initName.substring(initName.lastIndexOf("."));
            // 新图片
            File newFile = new File(savePath, newName);
            // 将内存中的数据写入磁盘
            singleFile.transferTo(newFile);
            // 把新的图片写入到对象中，方便数据库中更新
            Car car = carService.find(id);
            car.setImg(newName);
            int rows = carService.modify(car);
        }
        return "success";
    }

    /**
     * 多个图片上传
     * @param multipartFiles
     * @return
     * @throws IOException
     */
    @RequestMapping("/multipart_upload")
    public String uploadFiles(@RequestParam("multipartFile") MultipartFile[] multipartFiles) throws IOException {
        // 图片存储绝对路径
        String savePath = "F:\\pic";
        if (multipartFiles != null && multipartFiles.length != 0) {
            //遍历并保存文件
            for (MultipartFile file : multipartFiles) {
                file.transferTo(new File(savePath + separatorChar + file.getOriginalFilename()));
            }
        }
        return "success";
    }
}
