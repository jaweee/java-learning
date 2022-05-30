package com.jaweee.service;

import com.jaweee.po.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/5/28 21:53
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public interface ProductService {
    /**
     * @description: TODO
     * @param: id
     * @return Product
     * @author jiawei
     * @date 2022/5/29 09:23
    */
    public Product getProduct(String id);

    /**
     * @description: TODO
     * @param:
     * @return Product List
     * @author jiawei
     * @date 2022/5/29 09:24
    */
    public List<Product> listProducts();


    /**
     *
     */
    public void saveProduct(Product product);
}
