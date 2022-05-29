package com.jaweee.mappertest;

import com.jaweee.dao.ProductMapper;
import com.jaweee.po.Product;
import com.jaweee.service.ProductService;
import com.jaweee.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/5/29 08:53
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {

    @Test
    public void testProductMapperInterface(){
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProduct("ANV01");
        List<Product> list = productService.listProducts();
        System.out.println(product.toString());
        for(Product item : list){
            System.out.println(item.toString());
        }
    }


}
