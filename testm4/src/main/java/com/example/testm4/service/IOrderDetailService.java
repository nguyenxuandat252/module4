package com.example.testm4.service;

import com.example.testm4.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface IOrderDetailService {
    Page<OrderDetail> getAll(Pageable pageable);
    Page<OrderDetail> findAllByDateBuyBetween(
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate, Pageable pageable
    );
    OrderDetail findById(int id);
    void save(OrderDetail orderDetail);
}
