package com.jaweee.mappertest;

import com.jaweee.dao.ProductMapper;
import com.jaweee.po.Product;
import com.jaweee.service.ProductService;
import com.jaweee.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
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

    @Autowired
    ProductService productService;

    @Test
    public void testProductMapperInterface(){

    }

}
