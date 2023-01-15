package com.xq.controller;

import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class FileUploadController {
    //跳转到文件上传页面
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }
    //进行文件上传，如果是多文件上传就是用，MultipartFile[]
    @SneakyThrows
    @PostMapping("/upload")
    public String upload(String email, String username, MultipartFile headerImg,MultipartFile[] photos){
        if(!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("F:\\upload\\"+originalFilename));
        }
        if(photos.length>0){
            for(MultipartFile photo : photos){
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("F:\\upload\\"+originalFilename));
                }
            }
        }
        return "main";
    }
}
