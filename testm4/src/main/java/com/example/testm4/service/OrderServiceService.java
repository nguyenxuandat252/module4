package com.example.testm4.service;

import com.example.testm4.model.OrderDetail;
import com.example.testm4.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceService implements IOrderDetailService{
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Override
    public Page<OrderDetail> getAll(Pageable pageable) {
        return orderDetailRepository.findAll(pageable);
    }

    @Override
    public Page<OrderDetail> findAllByDateBuyBetween(LocalDate fromDate, LocalDate toDate, Pageable pageable) {
        return orderDetailRepository.findAllByDateBuyBetween(fromDate,toDate,pageable);
    }

    @Override
    public OrderDetail findById(int id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

}
