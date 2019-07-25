package com.oocl.packagebooking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.packagebooking.modle.PackageOrder;
import com.oocl.packagebooking.service.PackageOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PackageOrderTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private PackageOrderService packageOrderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void should_return_packageOrders_when_request_all() throws Exception {

        PackageOrder packageOrder = new PackageOrder();
        List<PackageOrder> expectResult = new ArrayList<PackageOrder>();
        for (int i=0;i<3;i++){
            expectResult.add(packageOrder);
        }

        given(packageOrderService.getPackageOrders())
                .willReturn(expectResult);

        mvc.perform(get("/packageOrders"))
                .andExpect(content().string(objectMapper.writeValueAsString(expectResult)));
    }

    @Test
    public void should_return_packageOrder_when_post_packageOrder() throws Exception {

        PackageOrder packageOrder = new PackageOrder("201907240001","Demi","18075525725","已预约",new Date(),3.0);

        given(packageOrderService.addPackageOrder(packageOrder))
                .willReturn(packageOrder);

        mvc.perform(post("/packageOrders",packageOrder))
                .andExpect(content().string(objectMapper.writeValueAsString(packageOrder)));
    }

    @Test
    public void should_return_packageOrders_when_query_by_status() throws Exception {

        PackageOrder packageOrder = new PackageOrder("201907240001","Demi","18075525725","已预约",new Date(),3.0);
//        PackageOrder packageOrder2 = new PackageOrder("201907240002","Demi2","18075525725","已取件",new Date(),3.0);
        List<PackageOrder> expectResult = new ArrayList<PackageOrder>();
        expectResult.add(packageOrder);

        given(packageOrderService.getPackageOrdersByStatus("已预约"))
                .willReturn(expectResult);

        mvc.perform(get("/packageOrders","已预约"))
                .andExpect(content().string(objectMapper.writeValueAsString(expectResult)));
    }

    @Test
    public void should_return_packageOrder_when_update_status() throws Exception {

        PackageOrder packageOrder = new PackageOrder("201907240001","Demi","18075525725","已预约",new Date(),3.0);
        PackageOrder packageOrder1 = new PackageOrder("201907240001","Demi","18075525725","已取件",new Date(),3.0);
        packageOrder1.setId((long) 1);

        given(packageOrderService.updatePackageOrderStatus((long) 1,packageOrder))
                .willReturn(packageOrder1);

        mvc.perform(put("/packageOrders/",1,packageOrder))
                .andExpect(content().string(objectMapper.writeValueAsString(packageOrder1)));
    }

    @Test
    public void should_return_packageOrders_when_query_by_orderTime() throws Exception {

        PackageOrder packageOrder = new PackageOrder("201907240001","Demi","18075525725","已预约",new Date(),3.0);
//        PackageOrder packageOrder2 = new PackageOrder("201907240002","Demi2","18075525725","已取件",new Date(),3.0);

        List<PackageOrder> expectResult = new ArrayList<PackageOrder>();
        expectResult.add(packageOrder);

        given(packageOrderService.getPackageOrdersByOrderTime(new Date()))
                .willReturn(expectResult);

        mvc.perform(get("/packageOrders",new Date()))
                .andExpect(content().string(objectMapper.writeValueAsString(expectResult)));
    }


}
