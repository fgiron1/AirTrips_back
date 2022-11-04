package com.airtrips.prices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.Instant;

@SpringBootTest
class PricesApplicationTests {
	@Autowired
	private PriceService service;
	private final boolean HAS_LUGGAGE = true;
	private final int AGE = 1;
	private final int DISTANCE = 1000;
	private final Instant DATE = Instant.now();

	@Test
	void CalculatePrice_ReturnsNewValue_WhenUsingValidPrice() {
		int price = service.calculatePrice(HAS_LUGGAGE, AGE, DISTANCE, DATE );
		//
		Assert.isTrue(price != 200, "The returned price is diferent than 200 € (base price)");
	}
}
