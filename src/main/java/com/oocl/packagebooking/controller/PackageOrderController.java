package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.modle.PackageOrder;
import com.oocl.packagebooking.service.PackageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
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
    public List<PackageOrder> getPackageOrdersByStatus(@RequestParam String status){
        return  packageOrderService.getPackageOrdersByStatus(status);
    }

    @GetMapping(value = "/packageOrders",params = {"orderTime"})
    public List<PackageOrder> getPackageOrdersByOrderTime(@PathVariable Date orderTime){
        return  packageOrderService.getPackageOrdersByOrderTime(orderTime);
    }

    @PutMapping("/packageOrders/{id}")
    public PackageOrder updatePackageOrderStatus(@RequestParam Long id, @RequestBody PackageOrder packageOrder) {
        return  packageOrderService.updatePackageOrderStatus(id,packageOrder);
    }
}
