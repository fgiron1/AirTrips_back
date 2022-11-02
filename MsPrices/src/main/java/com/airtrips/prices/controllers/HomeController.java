package com.airtrips.prices.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZonedDateTime;

@RestController
public class HomeController {

    @GetMapping("/api/v1/price")
    @ResponseBody
    public ResponseEntity<String> calculatePrice(@RequestParam(required = false, value = "hasLuggage") String hasLuggage,
                                                 @RequestParam(required = false, value = "date") String date,
                                                 @RequestParam(required = false, value = "distance") String distance,
                                                 @RequestParam(required = false, value = "age") String age
                                                  ){
        // Converting the query parameters to their real data type.
        boolean hasLuggageFinal = hasLuggage.equals("true");
        Instant dateFinal = null;
        try{
            dateFinal = Instant.parse(date);
        } catch (Exception e) {
            return new ResponseEntity<>("Date supplied is in a non-accepted format. The accepted format is ISO-8601", HttpStatus.BAD_REQUEST);
        }

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
            return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
        } else {
            //return new ResponseEntity<>(Double.toString(finalPrice), HttpStatus.OK);
            return new ResponseEntity<>("Data received:" +
                     "\nhasLuggageFinal: " + hasLuggageFinal
                   + "\ndateFinal: " + dateFinal
                   + "\ndistanceFinal: " + distanceFinal
                   + "\nageFinal: " + ageFinal, HttpStatus.OK);
        }
    }
}
