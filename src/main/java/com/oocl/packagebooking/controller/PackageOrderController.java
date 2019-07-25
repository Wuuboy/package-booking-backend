package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.modle.PackageOrder;
import com.oocl.packagebooking.service.PackageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PackageOrderController {

    @Autowired
    private PackageOrderService packageOrderService;

    @GetMapping("/packageOrders")
    public List<PackageOrder> getPackageOrders(){
        return  packageOrderService.getPackageOrders();
    }

    @PostMapping("/packageOrders")
    public PackageOrder addPackageOrder(@RequestBody PackageOrder packageOrder){
        return packageOrderService.addPackageOrder(packageOrder);
    }
    @GetMapping(value = "/packageOrders",params = {"status"})
    public List<PackageOrder> getPackageOrdersByStatus(@PathVariable String status){
        return  packageOrderService.getPackageOrdersByStatus(status);
    }
}
