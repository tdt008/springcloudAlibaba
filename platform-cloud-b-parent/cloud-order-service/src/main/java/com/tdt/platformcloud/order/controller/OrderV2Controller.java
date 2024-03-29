package com.tdt.platformcloud.order.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.tdt.platformcloud.order.domain.dto.OrderDTO;
import com.tdt.platformcloud.order.domain.vo.ProductVO;
import com.tdt.platformcloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/order2")
public class OrderV2Controller {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 购买一件商品: 引入注册中心; 使用ribbon
     * @param pid
     * @return
     */
    @GetMapping("/prod-v3/{pid}")
    public OrderDTO orderV3(@PathVariable("pid") Long pid) {
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
        // 从nacos中获取实例地址
        String url = "cloud-product-service";
        String realUrl = "http://" + url + "/cloud-product-service/product/";

        //通过restTemplate调用商品微服务
        ProductVO product = restTemplate.getForObject(realUrl + pid, ProductVO.class);
        log.info(">>从nacos中获取到的微服务地址为:" + url);
        //模拟一次网络延时
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(">>商品信息,查询结果:" + product);
        OrderDTO order = new OrderDTO();
        order.setId(IdWorker.getId());
        order.setUid(1L);
        order.setUsername("测试用户");
        order.setPid(product.getId());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setQuantity(1);
        // orderService.save(order);
        log.info("创建订单成功,订单信息为{}", order);

        return order;
    }


    @RequestMapping("/order/message")
    public String message() {
        return "高并发下的问题测试";
    }

}
