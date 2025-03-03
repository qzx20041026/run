package com.qzx.Service;

import com.qzx.pojo.addresses;
import com.qzx.pojo.order;

import java.util.List;

public interface orderService {
    List<order> list();

    addresses get(Integer addressesId);
}
