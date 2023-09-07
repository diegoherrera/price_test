package com.comercioelectronic.precios.domain.Service;

import com.comercioelectronic.precios.Application.Request.QueryPrice;
import com.comercioelectronic.precios.Application.Response.QueryDto;
import com.comercioelectronic.precios.domain.Price;

import java.util.List;

public interface PriceService {

    Price createPrice(Price price);
    Price getPriceById(long priceId);

    List< Price > getAllPrice();

    QueryDto getQueryPrice(QueryPrice queryprice);

    void deletePrice(long id);
}
