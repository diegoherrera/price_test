package com.comercioelectronic.precios.domain;



import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name="PRICE")
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="BRAND_ID")
    private Long brand;

    @Column(name="START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Column(name="END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Column(name="PRICE_LIST")
    private Long pricelist;

    @Column(name="PRODUCT_ID")
    private Long product;

    @Column(name="PRIORITY")
    private Integer priority;

    @Column(name="PRICE")
    private BigDecimal price;

    @Column(name="CURR")
    private String curr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
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

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}
