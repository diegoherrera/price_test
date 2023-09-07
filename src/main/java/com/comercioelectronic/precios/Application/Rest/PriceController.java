package com.comercioelectronic.precios.Application.Rest;
import com.comercioelectronic.precios.Application.Request.QueryPrice;
import com.comercioelectronic.precios.Application.Response.QueryDto;
import com.comercioelectronic.precios.domain.Exception.ResourceNotFoundException;
import com.comercioelectronic.precios.domain.Price;
import com.comercioelectronic.precios.domain.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/price")
    public ResponseEntity <List<Price>> getAllProduct() {
        return ResponseEntity.ok().body(priceService.getAllPrice());
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<Price> getProductById(@PathVariable Long id) {
        Price price = priceService.getPriceById(id);
        return ResponseEntity.ok().body(price);
    }

    @PostMapping("/price")
    public ResponseEntity < Price > createProduct(@RequestBody Price price) {
        return ResponseEntity.ok().body(this.priceService.createPrice(price));
    }

    @PostMapping("/queryprice")
    public ResponseEntity < QueryDto > queryPrice(@RequestBody QueryPrice queryprice) {
        return ResponseEntity.ok().body(priceService.getQueryPrice(queryprice));
    }

    @DeleteMapping("/price/{id}")
    public HttpStatus deleteProduct(@PathVariable Long id) {
        this.priceService.deletePrice(id);
        return HttpStatus.OK;
    }

}


