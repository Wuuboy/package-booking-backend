package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.modle.PackageOrder;
import com.oocl.packagebooking.service.PackageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageOrderController {

    @Autowired
    private PackageOrderService packageOrderService;

    @GetMapping("/packageOrders")
    public List<PackageOrder> getPackageOrders(){
        return  packageOrderService.getPackageOrders();
    }
}
