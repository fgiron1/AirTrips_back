package com.airtrips.prices.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZonedDateTime;

@RestController
public class HomeController {

    @GetMapping("/api/v1/price")
    public ResponseEntity<String> calculatePrice(@RequestParam(name = "hasLuggage") String hasLuggage,
                                                 @RequestParam(name = "departureDate") String date,
                                                 @RequestParam(name = "distance") String distance,
                                                 @RequestParam(name = "age") String age
                                                  ){
        // Converting the query parameters to their real data type.
        boolean hasLuggageFinal = hasLuggage.equals("true");
        Instant dateFinal = ZonedDateTime.parse(date).toInstant();
        double distanceFinal = Double.parseDouble(distance);
        int ageFinal = Integer.parseInt(age);

        boolean isValidRequest = false;
        String errorMsg = "Invalid query parameters.";
        double finalPrice = 0;

        // Validation logic
        if (dateFinal.isBefore(Instant.now())){
            errorMsg = "The departure date specified is a date in the past.";
        } else if(ageFinal <= 0) {
            errorMsg = "The age of the passenger can't be 0 or less years old.";
        } else if(distanceFinal <= 0) {
            errorMsg = "The distance can't be 0 or less kilometers.";
        } else {
            isValidRequest = true;
        }

        //TODO: TDD - PRICE-CALCULATING ALGORITHM GOES HERE

        if(!isValidRequest){
            return new ResponseEntity<>(errorMsg, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Double.toString(finalPrice), HttpStatus.OK);
        }
        return new ResponseEntity<>("The price for that flight would be: 84.21 €" + hasLuggage + departureDate + arrivalDate, HttpStatus.OK);
    }
}
