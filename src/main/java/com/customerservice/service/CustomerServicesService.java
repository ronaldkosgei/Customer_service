package com.customerservice.service;

import com.customerservice.dto.CustomerServicesDto;
import com.customerservice.entity.CustomerServices;

import java.util.Optional;

public interface CustomerServicesService {

    CustomerServices saveCustomerServices(CustomerServicesDto dto);

    Optional<CustomerServices> getCustomerServicesById(Long customerServicesId);

    Optional<CustomerServices> updateCustomerServices(Long customerServicesId, CustomerServicesDto dto);

    Optional<Object> deleteCustomerServices(Long customerServicesId);
}
