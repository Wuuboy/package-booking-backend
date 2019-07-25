package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.modle.PackageOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PackageOrderRepository extends JpaRepository<PackageOrder,Long> {
    List<PackageOrder> findAllByStatus(String status);

    List<PackageOrder> findAllByOrderTime(Date orderTime);
}
