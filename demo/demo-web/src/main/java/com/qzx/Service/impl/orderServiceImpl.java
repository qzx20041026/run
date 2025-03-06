package com.qzx.Service.impl;

import com.qzx.Mapper.orderMapper;
import com.qzx.Service.orderService;
import com.qzx.pojo.addresses;
import com.qzx.pojo.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class orderServiceImpl implements orderService {
    @Autowired
    private orderMapper orderMapper;
    @Override
    public List<order> list() {
        List<order> list = orderMapper.list();
        return list;
    }

    @Override
    public addresses get(Integer addressesId) {
        addresses addresses = orderMapper.get(addressesId);
        System.out.println(addresses);
        return addresses;
    }

    @Override
    public void up(order o) {
        o.setUpdatedTime(LocalDateTime.now());
        orderMapper.up(o);
    }
}
