package com.airtrips.MsFlight.Controllers;

import com.airtrips.MsFlight.Models.Customer;
import com.airtrips.MsFlight.Models.Flight;
import com.airtrips.MsFlight.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/flight")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer c){
        HttpStatus code = null;

        //1. VALIDATION LOGIC
        if(validateCustomer(c)){
            try{
                service.createCustomer(c);
                code = HttpStatus.CREATED;
            } catch (Exception e){
                code = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            code = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<Customer>(c, code);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id){
        Customer c = null;
        HttpStatus status = null;
        try{
            c = service.getCustomerById(id);
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(c, status);
    }


    private boolean validateCustomer(Customer c){
        boolean valid = true;
        if(c.getName() == null ||
                c.getNationality() == null ||
                c.getAge() == null ||
                c.getLast_name() == null) {
            valid = false;
        }
        return valid;
    }
}
