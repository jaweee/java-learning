package com.jaweee.controller;

import com.jaweee.po.Product;
import com.jaweee.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/5/28 22:02
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

//    @GetMapping("/list")
//    public List<Product> listProducts(){
//        return productService.listProducts();
//    }

//    @GetMapping("/list/{id}")
//    public Product getProduct(@PathVariable("id") String id){
//        return productService.getProduct(id);
//    }

    @GetMapping("/list")
    public Product getProduct(@RequestParam(value = "id") String id){

        return productService.getProduct(id);
    }
}
