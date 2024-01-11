package com.customerservice.controller;

import com.customerservice.dto.CustomerServicesDto;
import com.customerservice.entity.CustomerServices;
import com.customerservice.service.CustomerServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer-services")
public class CustomerServicesController {

    @Autowired
    private CustomerServicesService customerServicesService;

    public CustomerServicesController(CustomerServicesService customerServicesService) {
        this.customerServicesService = customerServicesService;
    }


    @PostMapping("/save")
    public CustomerServices saveCustomerServices(@RequestBody CustomerServicesDto dto) {
        return customerServicesService.saveCustomerServices(dto);
    }

    @GetMapping("/get/{serviceId}")
    public Optional<CustomerServices> getCustomerServicesById(@PathVariable Long serviceId) {
        return customerServicesService.getCustomerServicesById(serviceId);
    }

    @PutMapping("/update/{serviceId}")
    public Optional<CustomerServices> updateCustomerServices(@PathVariable Long serviceId, @RequestBody CustomerServicesDto dto) {
        return customerServicesService.updateCustomerServices(serviceId, dto);
    }

    @DeleteMapping("/delete/{serviceId}")
    public Optional<Object> deleteCustomerServices(@PathVariable Long serviceId) {
        return customerServicesService.deleteCustomerServices(serviceId);
    }
}
