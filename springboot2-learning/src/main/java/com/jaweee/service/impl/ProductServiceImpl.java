package com.jaweee.service.impl;

import com.jaweee.dao.ProductMapper;
import com.jaweee.po.Product;
import com.jaweee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/5/29 09:03
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
@Component
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public Product getProduct(String id) {
        return productMapper.getProduct(id);
    }

    /**
     * @return Product List
     * @description: TODO
     * @param:
     * @author jiawei
     * @date 2022/5/29 09:24
     */
    @Override
    public List<Product> listProducts() {
        return productMapper.listProducts();
    }
}
