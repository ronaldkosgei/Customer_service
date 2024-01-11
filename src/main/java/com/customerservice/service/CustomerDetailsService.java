package com.customerservice.service;

import com.customerservice.dto.CustomerDetailsDto;
import com.customerservice.entity.CustomerDetails;

import java.util.Optional;

public interface CustomerDetailsService {

    CustomerDetails saveCustomerDetails(CustomerDetailsDto dto);

    Optional<CustomerDetails> getCustomerDetailsById(Long customerId);

    Optional<CustomerDetails> updateCustomerDetails(Long customerId, CustomerDetailsDto dto);

    Optional<Object> deleteCustomerDetails(Long customerId);

}
