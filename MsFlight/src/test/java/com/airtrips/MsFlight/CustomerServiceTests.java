package com.airtrips.MsFlight;

import com.airtrips.MsFlight.Models.Customer;
import com.airtrips.MsFlight.Models.Ticket;
import com.airtrips.MsFlight.Services.CustomerService;
import org.hibernate.annotations.Source;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.Assert;

import java.util.*;

import static org.assertj.core.api.Fail.fail;

@SpringBootTest
public class CustomerServiceTests {
    @Autowired
    private CustomerService service;
    private static UUID VALID_ID = UUID.fromString("ad033055-57c1-4a3a-9701-7da830ef2e2a");
    private static UUID INVALID_ID = UUID.fromString("ad033055-57c1-4a3a-9701-7da830ef2t1b");
    private static Customer c = new Customer("First", "Last", 12, "Spanish", INVALID_ID.toString(), null );
    private static Customer VALID_CUSTOMER = new Customer("Pedro", "Mendoza", 20, "Spain", "77854126D", new ArrayList<Ticket>());
    private static Customer INVALID_CUSTOMER = new Customer(null, null, null, null, null, null);

    @Test

    void GetAllCustomers_WorkAsExpected_WhenCalled() {
        List<Customer> customers = service.getAllCustomers();

        Assert.notEmpty(customers, "Returned list of customer is not empty");
    }

    @Test
    void GetCustomerById_WorkAsExpected_WhenUsingValidId() {
        Customer customer = service.getCustomerById(VALID_ID.toString());

        Assert.notNull(customer, "Returned customer is not null");
        Assert.isTrue(customer.getId().equals(VALID_ID), "Returned customer have the same ID");
    }

    @Test
    void GetCustomerById_WorkAsExpected_WhenUsingInvalidId() {
        Customer customer = service.getCustomerById(INVALID_ID.toString());

        Assert.notNull(customer, "Returned customer is not null");
        Assert.isTrue(customer.getId().equals(INVALID_ID), "Returned customer have the same ID");
    }

    @Test
    void CreateCustomer_WorkAsExpected_WhenUsingValidData() {
        Customer customer = service.createCustomer(VALID_CUSTOMER);

        Assert.notNull(customer, "Returned customer is not null");
        Assert.notNull(customer.getId(), "Returned customer have a valid ID");
    }

    @Test
    void CreateCustomer_WorkAsExpected_WhenUsingInvalidData() {
        try{
            Customer customer = service.createCustomer(INVALID_CUSTOMER);
        } catch (DataIntegrityViolationException e){
            return;
        }

        fail("Could create an invalid customer");
    }
}
