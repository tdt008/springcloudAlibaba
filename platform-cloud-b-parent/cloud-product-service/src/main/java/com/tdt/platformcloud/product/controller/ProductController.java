package com.tdt.platformcloud.product.controller;

import com.tdt.platformcloud.product.domain.dto.ProductDTO;
import com.tdt.platformcloud.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{pid}")
    public ProductDTO product(@PathVariable("pid") Long pid) {
        log.info("product pid:{}", pid);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(pid);
        productDTO.setPprice(BigDecimal.valueOf(100));
        productDTO.setPname("热销产品-tes");
        return productDTO;
    }

}
