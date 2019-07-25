package com.oocl.packagebooking.service;

import com.oocl.packagebooking.modle.PackageOrder;
import com.oocl.packagebooking.repository.PackageOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PackageOrderService {
    @Autowired
    private PackageOrderRepository packageOrderRepository;

    public List<PackageOrder> getPackageOrders() {
        return packageOrderRepository.findAll();
    }

    public PackageOrder addPackageOrder(PackageOrder packageOrder) {
        return packageOrderRepository.saveAndFlush(packageOrder);
    }

    public List<PackageOrder> getPackageOrdersByStatus(String status) {
        return packageOrderRepository.findAllByStatus(status);
    }

    public PackageOrder updatePackageOrderStatus(Long id, PackageOrder packageOrder) {
        PackageOrder packageOrderFinded = packageOrderRepository.findById(id).orElse(null);
        if (packageOrderFinded != null){
            packageOrderFinded.setStatus(packageOrder.getStatus());
            packageOrderFinded.setOrderNumber(packageOrder.getOrderNumber());
            packageOrderFinded.setOrderTime(packageOrder.getOrderTime());
            packageOrderFinded.setPhoneNumber(packageOrder.getPhoneNumber());
            packageOrderFinded.setUserName(packageOrder.getUserName());
            packageOrderFinded.setWeight(packageOrder.getWeight());
        }
       return  packageOrderRepository.saveAndFlush(packageOrderFinded);
    }

    public List<PackageOrder> getPackageOrdersByOrderTime(Date orderTime) {
        return packageOrderRepository.findAllByOrderTime(orderTime);
    }
}
