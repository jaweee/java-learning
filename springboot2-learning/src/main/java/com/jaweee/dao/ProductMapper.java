package com.jaweee.dao;

import com.jaweee.po.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/5/28 21:49
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
@Mapper
public interface ProductMapper {

    /**
     * @description: TODO
     * @param: id
     * @return Product
     * @author jiawei
     * @date 2022/5/29 11:16
    */
    Product getProduct(String id);

    /**
     * @Description:
     * @return
     * @author jiawei
     * @date 2022/5/29 08:57
    */
    List<Product> listProducts();

    /**
     *
     */

    void insert(Product product);
}
