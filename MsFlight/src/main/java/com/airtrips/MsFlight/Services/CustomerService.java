package com.airtrips.MsFlight.Services;

import com.airtrips.MsFlight.Models.Customer;
import com.airtrips.MsFlight.Repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repo;

    @Transactional
    public Customer createCustomer(Customer c){
        repo.save(c);
        return c;
    }

    @Transactional
    public List<Customer> getAllCustomers(){
        return repo.findAll();
    }

    @Transactional
    public Customer getCustomerById(String id){
        return repo.findById(UUID.fromString("id")).get();
    }

}
