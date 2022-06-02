package com.jaweee.controller;

import com.jaweee.po.Product;
import com.jaweee.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
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

    @GetMapping("/list")
    public List<Product> listProducts(){
        return productService.listProducts();
    }

//    @GetMapping("/list/{id}")
//    public Product getProduct(@PathVariable("id") String id){
//        return productService.getProduct(id);
//    }

    @GetMapping("/list/{id}")
    public Product getProduct(@PathVariable(value = "id") String id){

        return productService.getProduct(id);
    }

    @GetMapping("/testinsert")
    public void testInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/product/insert").forward(request,response);
    }

    @GetMapping("/insert")
    public void addProduct(){

        // 使用controller层进行添加产品是没有问题的，为什么test中就有问题
        Product insertProduct = new Product();
        insertProduct.setProdId("lalal");
        insertProduct.setVendId(Long.valueOf(1001));
        insertProduct.setProdName("ja");
        insertProduct.setProdPrice(BigDecimal.valueOf(12.4));
        insertProduct.setProdDescription("hahah");
        productService.saveProduct(insertProduct);
    }
}
