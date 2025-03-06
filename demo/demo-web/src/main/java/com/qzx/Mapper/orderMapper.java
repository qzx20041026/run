package com.qzx.Mapper;

import com.qzx.pojo.addresses;
import com.qzx.pojo.order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface orderMapper {
    @Select("select * from orders")
    List<order> list();

    addresses get(Integer addressesId);
    @Update("update orders set status=#{status},updatedTime=#{updatedTime} where orderId=#{orderId}")
    void up(order o);
}
