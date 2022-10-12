package com.tdt.platformcloud.product.controller;

import com.tdt.platformcloud.product.domain.dto.ProductDTO;
import com.tdt.platformcloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{pid}")
    public ProductDTO product(@PathVariable("pid") Long pid) {
        ProductDTO productDTO = productService.getById(pid);
        System.out.println(productDTO.getStock());
        return productDTO;
    }

}
