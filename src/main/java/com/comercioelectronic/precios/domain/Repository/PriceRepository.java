package com.comercioelectronic.precios.domain.Repository;

import com.comercioelectronic.precios.Application.Response.QueryDto;
import com.comercioelectronic.precios.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price,Long> {

    Price findFirstByProductAndBrandAndStartLessThanEqualAndEndGreaterThanEqualOrderByPriorityDesc(long product, long brand, Date start, Date end);
    List<Price> findByProductAndBrandAndStartLessThanEqualAndEndGreaterThanEqualOrderByPriorityDesc(long product, long brand, Date start, Date end);
}
