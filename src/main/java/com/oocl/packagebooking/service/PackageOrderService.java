package com.oocl.packagebooking.service;

import com.oocl.packagebooking.modle.PackageOrder;
import com.oocl.packagebooking.repository.PackageOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public PackageOrder updatePackageOrderStatus(Long id) {
        PackageOrder packageOrderFinded = packageOrderRepository.findById(id).orElse(null);
        if (packageOrderFinded != null){
            packageOrderFinded.setStatus("已取件");
        }
       return  packageOrderRepository.saveAndFlush(packageOrderFinded);
    }


    public PackageOrder setOrderTimeByOrderNumber(String orderNumber, Object packageOrder) throws ParseException {

        String  orderTime = String.valueOf(packageOrder).split("=")[2].split("}")[0];

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date orderTimeFormated = sdf.parse(orderTime);
        System.out.println(sdf.format(orderTimeFormated));

        PackageOrder packageOrderFinded = packageOrderRepository.findAllByOrderNumber(orderNumber).get(0);
        if (packageOrderFinded!=null){
            packageOrderFinded.setOrderTime(orderTimeFormated);
        }
        return packageOrderRepository.saveAndFlush(packageOrderFinded);
    }
}
