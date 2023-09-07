package com.comercioelectronic.precios;
import java.math.BigDecimal;
import java.util.Calendar;

import com.comercioelectronic.precios.Application.Request.QueryPrice;
import com.comercioelectronic.precios.Application.Response.QueryDto;
import com.comercioelectronic.precios.domain.Price;
import com.comercioelectronic.precios.domain.Service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

@SpringBootTest
class PreciosApplicationTests {

	@Autowired
	private PriceService priceService;

	public QueryDto queryPriceTest(QueryPrice queryprice) {
		return priceService.getQueryPrice(queryprice);

	}

	public Date getDate(int year, int month, int day, int hour, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		return  calendar.getTime();
	}


	@Test
	void queryPriceTest0() {

		Long brand = 1L;
		Long product = 35455L;
		String curr = "EUR";

		List<Price> data = priceService.getAllPrice();

		if (data.size() == 0) {
			Date startDate = this.getDate(2020,6,14,0,0,0);
			Date endtDate = this.getDate(2020,12,31,23,59,59);
			Price ObjectTest1 = new Price();
			ObjectTest1.setBrand(brand);
			ObjectTest1.setStart(startDate);
			ObjectTest1.setEnd(endtDate);
			ObjectTest1.setPricelist(1L);
			ObjectTest1.setProduct(product);
			ObjectTest1.setPriority(0);
			ObjectTest1.setPrice(new BigDecimal("35.50"));
			ObjectTest1.setCurr(curr);
			Price saveTest1 = priceService.createPrice(ObjectTest1);
			assertThat(saveTest1).isNotNull();

			startDate = this.getDate(2020,6,14,15,0,0);
			endtDate = this.getDate(2020,6,14,18,30,0);
			Price ObjectTest2 = new Price();
			ObjectTest2.setBrand(brand);
			ObjectTest2.setStart(startDate);
			ObjectTest2.setEnd(endtDate);
			ObjectTest2.setPricelist(2L);
			ObjectTest2.setProduct(product);
			ObjectTest2.setPriority(1);
			ObjectTest2.setPrice(new BigDecimal("25.45"));
			ObjectTest2.setCurr(curr);
			Price saveTest2 = priceService.createPrice(ObjectTest2);
			assertThat(saveTest2).isNotNull();

			startDate = this.getDate(2020,6,15,0,0,0);
			endtDate = this.getDate(2020,6,15,11,0,0);
			Price ObjectTest3 = new Price();
			ObjectTest3.setBrand(brand);
			ObjectTest3.setStart(startDate);
			ObjectTest3.setEnd(endtDate);
			ObjectTest3.setPricelist(3L);
			ObjectTest3.setProduct(product);
			ObjectTest3.setPriority(1);
			ObjectTest3.setPrice(new BigDecimal("30.50"));
			ObjectTest3.setCurr(curr);
			Price saveTest3 = priceService.createPrice(ObjectTest3);
			assertThat(saveTest3).isNotNull();

			startDate = this.getDate(2020,6,15,16,0,0);
			endtDate = this.getDate(2020,12,31,23,59,59);
			Price ObjectTest4 = new Price();
			ObjectTest4.setBrand(brand);
			ObjectTest4.setStart(startDate);
			ObjectTest4.setEnd(endtDate);
			ObjectTest4.setPricelist(4L);
			ObjectTest4.setProduct(product);
			ObjectTest4.setPriority(1);
			ObjectTest4.setPrice(new BigDecimal("38.95"));
			ObjectTest4.setCurr(curr);
			Price saveTest4 = priceService.createPrice(ObjectTest4);
			assertThat(saveTest4).isNotNull();
		}

	}

	@Test
	void queryPriceTest1() {

		//Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		Date fechaYHora = this.getDate(2020,6,14,10,0,0);
		QueryPrice queryprice = new QueryPrice();
		queryprice.setDate(fechaYHora);
		queryprice.setBrand(1L);
		queryprice.setProduct(35455L);
		QueryDto query = this.queryPriceTest(queryprice);
		assertThat(query.getBrand()).isEqualTo(1L);
		assertThat(query.getProduct()).isEqualTo(35455L);
		assertThat(query.getPrice()).isEqualTo(new BigDecimal("35.50") );
	}

	@Test
	void queryPriceTest2() {
		// Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		Date fechaYHora = this.getDate(2020,6,14,16,0,0);
		QueryPrice queryprice = new QueryPrice();
		queryprice.setDate(fechaYHora);
		queryprice.setBrand(1L);
		queryprice.setProduct(35455L);
		QueryDto query = this.queryPriceTest(queryprice);
		assertThat(query.getBrand()).isEqualTo(1L);
		assertThat(query.getProduct()).isEqualTo(35455L);
		assertThat(query.getPrice()).isEqualTo(new BigDecimal("25.45") );
	}

	@Test
	void queryPriceTest3() {
		// Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		Date fechaYHora = this.getDate(2020,6,14,21,0,0);
		QueryPrice queryprice = new QueryPrice();
		queryprice.setDate(fechaYHora);
		queryprice.setBrand(1L);
		queryprice.setProduct(35455L);
		QueryDto query = this.queryPriceTest(queryprice);
		assertThat(query.getBrand()).isEqualTo(1L);
		assertThat(query.getProduct()).isEqualTo(35455L);
		assertThat(query.getPrice()).isEqualTo(new BigDecimal("35.50") );
	}

	@Test
	void queryPriceTest4() {
		//Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
		Date fechaYHora = this.getDate(2020,6,15,10,0,0);
		QueryPrice queryprice = new QueryPrice();
		queryprice.setDate(fechaYHora);
		queryprice.setBrand(1L);
		queryprice.setProduct(35455L);
		QueryDto query = this.queryPriceTest(queryprice);
		assertThat(query.getBrand()).isEqualTo(1L);
		assertThat(query.getProduct()).isEqualTo(35455L);
		assertThat(query.getPrice()).isEqualTo(new BigDecimal("30.50") );
	}

	@Test
	void queryPriceTest5() {
		//Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
		Date fechaYHora = this.getDate(2020,6,16,21,0,0);
		QueryPrice queryprice = new QueryPrice();
		queryprice.setDate(fechaYHora);
		queryprice.setBrand(1L);
		queryprice.setProduct(35455L);
		QueryDto query = this.queryPriceTest(queryprice);
		assertThat(query.getBrand()).isEqualTo(1L);
		assertThat(query.getProduct()).isEqualTo(35455L);
		assertThat(query.getPrice()).isEqualTo(new BigDecimal("38.95") );
	}

}
