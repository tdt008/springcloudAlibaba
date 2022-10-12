package com.tdt.platformcloud.order.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.tdt.platformcloud.order.domain.dto.OrderDTO;
import com.tdt.platformcloud.order.domain.vo.ProductVO;
import com.tdt.platformcloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 购买一件商品
     * @param pid
     * @return
     */
    @GetMapping("/prod/{pid}")
    public OrderDTO order(@PathVariable("pid") Long pid) {
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
        //通过restTemplate调用商品微服务
        ProductVO product = restTemplate.getForObject(
                "http://localhost:9002/cloud-product-service/product/" + pid, ProductVO.class);

        log.info(">>商品信息,查询结果:" + product);
        OrderDTO order = new OrderDTO();
        order.setId(IdWorker.getId());
        order.setUid(1L);
        order.setUsername("测试用户");
        order.setPid(product.getId());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setQuantity(1);
        orderService.save(order);
        return order;
    }


}
