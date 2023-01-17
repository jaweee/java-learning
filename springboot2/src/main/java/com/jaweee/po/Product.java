package com.jaweee.po;

import java.math.BigDecimal;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/5/28 21:54
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class Product {

    /**
     *  商品id
     */
    public String prodId;

    /**
     *  供货商id
     */
    public Long vendId;

    /**
     * 商品名
     */
    public String prodName;

    /**
     * 商品价格
     */
    public BigDecimal prodPrice;

    /**
     * 商品描述
     */
    public String prodDescription;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public Long getVendId() {
        return vendId;
    }

    public void setVendId(Long vendId) {
        this.vendId = vendId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public BigDecimal getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(BigDecimal prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId='" + prodId + '\'' +
                ", vendId=" + vendId +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                ", prodDescription='" + prodDescription + '\'' +
                '}';
    }
}
