package com.qzx.Controller;

import com.qzx.Service.orderService;
import com.qzx.pojo.Result;
import com.qzx.pojo.addresses;
import com.qzx.pojo.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/order")
@RestController
public class orderContrller {
    @Autowired
    private orderService orderService;
    @GetMapping("/All")
    public Result list() {
        List<order>list= orderService.list();
        return Result.success(list);
    }
    @GetMapping
    private Result get(Integer addressesId) {
        addresses addresses= orderService.get(addressesId);
        return Result.success(addresses);
    }
}
