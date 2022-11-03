package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.models.Customer;
import com.airtrips.MsFlight.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {


}
