package com.comercioelectronic.precios.Application.Response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;


public class QueryDto {

    private Long product;
    private Long brand;
    private BigDecimal price;

    private Date start;

    private Date end;

    private Long pricelist;

    private Integer priority;

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Long getPricelist() {
        return pricelist;
    }

    public void setPricelist(Long pricelist) {
        this.pricelist = pricelist;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
