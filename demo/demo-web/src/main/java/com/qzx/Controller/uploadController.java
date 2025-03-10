package com.qzx.Controller;

import com.qzx.pojo.Result;
import com.qzx.utils.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@RequestMapping("/upload")
@RestController
public class uploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        return Result.success(url);
    }
}
