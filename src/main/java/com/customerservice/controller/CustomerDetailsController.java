package com.customerservice.controller;

import com.customerservice.dto.CustomerDetailsDto;
import com.customerservice.entity.CustomerDetails;
import com.customerservice.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer-details")
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;

    public CustomerDetailsController(CustomerDetailsService customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }


    @PostMapping("/create")
    public CustomerDetails saveCustomerDetails(@RequestBody CustomerDetailsDto dto) {
        return customerDetailsService.saveCustomerDetails(dto);
    }

    @GetMapping("/get/{customerId}")
    public Optional<CustomerDetails> getCustomerDetailsById(@PathVariable Long customerId) {
        return customerDetailsService.getCustomerDetailsById(customerId);
    }

    @PutMapping("/update/{customerId}")
    public Optional<CustomerDetails> updateCustomerDetails(@PathVariable Long customerId, @RequestBody CustomerDetailsDto dto) {
        return customerDetailsService.updateCustomerDetails(customerId, dto);
    }

    @DeleteMapping("/delete/{customerId}")
    public Optional<Object> deleteCustomerDetails(@PathVariable Long customerId) {
        return customerDetailsService.deleteCustomerDetails(customerId);
    }

}
