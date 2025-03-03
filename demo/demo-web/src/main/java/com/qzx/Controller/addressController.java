package com.qzx.Controller;

import com.qzx.Service.addressService;
import com.qzx.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/address")
@RestController
public class addressController {
    @Autowired
    private addressService addressService;
    @GetMapping
    private Result Alladdress(){
        List<Integer>list=addressService.list();
        return Result.success(list);
    }
}
