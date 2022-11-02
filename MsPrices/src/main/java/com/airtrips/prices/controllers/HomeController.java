package com.airtrips.prices.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class HomeController {

    @GetMapping("/api/v1/price")
    public ResponseEntity<String> calculatePrice(@RequestParam(required = false, name = "hasLuggage") String hasLuggage,
                                                 @RequestParam(required = false, name = "departureDate") String departureDate,
                                                 @RequestParam(required = false, name = "arrivalDate") String arrivalDate
                                                  ){
        if(hasLuggage.equals("true") || hasLuggage.equals("false")){
            
        }
        return new ResponseEntity<>("The price for that flight would be: 84.21 €" + hasLuggage + departureDate + arrivalDate, HttpStatus.OK);
    }
}
