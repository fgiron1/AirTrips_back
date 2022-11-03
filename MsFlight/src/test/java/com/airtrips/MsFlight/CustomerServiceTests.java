package com.airtrips.MsFlight;

import com.airtrips.MsFlight.models.Customer;
import com.airtrips.MsFlight.models.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.*;

@SpringBootTest
public class CustomerServiceTests {
    @Autowired
    private CustomerService service;
    private static UUID VALID_ID = UUID.fromString("ad033055-57c1-4a3a-9701-7da830ef2e2a");
    private static UUID INVALID_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static Customer VALID_CUSTOMER = new Customer("Pedro", "Mendoza", 20, "Spain", "77854126D", new ArrayList<Ticket>());
    private static Customer INVALID_CUSTOMER = new Customer(null, null, null, null, null, null);

    @Test
    GetAllCustomers_WorkAsExpected_WhenCalled() {
        List<Customer> customers = service.getAllCustomers();

        Assert.notEmpty(customers, "Returned list of customer is not empty");
    }

    @Test
    void GetCustomerById_WorkAsExpected_WhenUsingValidId() {
        Customer customer = service.getCustomer(VALID_ID);

        Assert.notNull(customer, "Returned customer is not null");
        Assert.isTrue(customer.getId().equals(VALID_ID), "Returned customer have the same ID");
    }

    @Test
    void GetCustomerById_WorkAsExpected_WhenUsingInvalidId() {
        Customer customer = service.getCustomer(INVALID_ID);

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
        Customer customer = service.createCustomer(INVALID_CUSTOMER);

        Assert.isNull(customer, "Returned customer is null");
    }
}
