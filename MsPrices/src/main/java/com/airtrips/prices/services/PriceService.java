package com.airtrips.prices.services;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;

@Service
public class PriceService {
    private final double BASE_PRICE = 200;

    public double calculatePrice(boolean has_luggage, int age, int distance, Instant date) {
        double price = BASE_PRICE;
        if (has_luggage) price += BASE_PRICE * 0.1;

        if (2 > age && age < 10) price += BASE_PRICE * 0.1;
        else if (age > 10) price += BASE_PRICE * 0.2;

        if (2500 < distance && distance <= 5000) price += BASE_PRICE * 0.25;
        if (5000 < distance && distance <= 10000) price += BASE_PRICE * 0.75;

        int month = Date.from(date).getMonth();

        if (5 <= month && month <= 9) price += BASE_PRICE * 0.50;

        return price;
    }
}
