package com.comercioelectronic.precios.domain.Service;

import com.comercioelectronic.precios.Application.Request.QueryPrice;
import com.comercioelectronic.precios.Application.Response.QueryDto;
import com.comercioelectronic.precios.domain.Exception.ResourceNotFoundException;
import com.comercioelectronic.precios.domain.Price;
import com.comercioelectronic.precios.domain.Repository.PriceRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PriceServiceImpl implements  PriceService {


    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public Price getPriceById(long priceId) {
        Optional< Price > productDb = this.priceRepository.findById(priceId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + priceId);
        }
    }

    @Override
    public List<Price> getAllPrice() {
        return this.priceRepository.findAll();
    }

    @Override
    public QueryDto getQueryPrice(QueryPrice queryprice) {
        /*final List<QueryDto> priceDtoList = new ArrayList<QueryDto>();
        priceRepository.findByProductAndBrandAndStartLessThanEqualAndEndGreaterThanEqualOrderByPriorityDesc(queryprice.getProduct(), queryprice.getBrand(), queryprice.getDate(), queryprice.getDate()).forEach(priceEntity -> {
          priceDtoList.add(modelMapper.map(priceEntity, QueryDto.class));
        });*/
        Price query = priceRepository.findFirstByProductAndBrandAndStartLessThanEqualAndEndGreaterThanEqualOrderByPriorityDesc(queryprice.getProduct(), queryprice.getBrand(), queryprice.getDate(), queryprice.getDate());
        return modelMapper.map(query, QueryDto.class);
    }

    @Override
    public void deletePrice(long id) {
        Optional < Price > priceDb = this.priceRepository.findById(id);

        if (priceDb.isPresent()) {
            this.priceRepository.delete(priceDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

}
