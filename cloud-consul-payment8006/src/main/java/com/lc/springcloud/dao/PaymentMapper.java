package com.lc.springcloud.dao;

import com.lc.springcloud.dto.Payment;
import org.apache.ibatis.annotations.Param;

//@Mapper(启动类加了MapperScan即可不写@Mapper)
public interface PaymentMapper {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
