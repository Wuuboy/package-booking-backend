package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.modle.PackageOrder;
import com.oocl.packagebooking.service.PackageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @PutMapping(value = "/packageOrders/{orderNumber}")
    public PackageOrder getPackageOrdersByOrderTime(@PathVariable String orderNumber,@RequestBody Object packageOrder) throws ParseException {
        return  packageOrderService.setOrderTimeByOrderNumber(orderNumber,packageOrder);
    }

//    @PutMapping("/packageOrders/{id}")
//    public PackageOrder updatePackageOrderStatus(@PathVariable Long id) {
//        return  packageOrderService.updatePackageOrderStatus(id);
//    }
}
