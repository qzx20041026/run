package com.qzx.Service.impl;

import com.qzx.Mapper.addressMapper;
import com.qzx.Service.addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class addressServiceImpl implements addressService {
    @Autowired
    private addressMapper addressMapper;
    @Override
    public List<Integer> list() {
        List<Integer> list = addressMapper.list();
        return list;
    }
}
