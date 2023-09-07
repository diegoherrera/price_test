package com.comercioelectronic.precios.Application.Request;

import jakarta.persistence.Column;

import java.util.Date;


public class QueryPrice {

    private Date date;
    private Long brand;
    private Long product;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }
}
