package com.example.testm4.repository;

import com.example.testm4.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    @Query("SELECT od \n" +
            "    FROM OrderDetail od \n" +
            "    JOIN od.orders o \n" +
            "    WHERE o.dateBuy BETWEEN :fromDate AND :toDate")
    Page<OrderDetail> findAllByDateBuyBetween(
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate, Pageable pageable
    );

    OrderDetail findById(int id);
}
