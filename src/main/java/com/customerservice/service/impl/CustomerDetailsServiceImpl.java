package com.customerservice.service.impl;

import com.customerservice.dto.CustomerDetailsDto;
import com.customerservice.entity.CustomerDetails;
import com.customerservice.repository.CustomerDetailsRepository;
import com.customerservice.service.CustomerDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {


    private static final String PHONE_NUMBER_REGEX = "^(2547\\d{8}|07\\d{8}|7\\d{8})$";
    private CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetailsServiceImpl(CustomerDetailsRepository customerDetailsRepository) {
        this.customerDetailsRepository = customerDetailsRepository;
    }


    @Override
    public CustomerDetails saveCustomerDetails(CustomerDetailsDto dto) {

       if (!isValidPhoneNumber(dto.getPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setFirstName(dto.getFirstName());
        customerDetails.setLastName(dto.getLastName());
        customerDetails.setPhoneNumber(dto.getPhoneNumber());
        customerDetails.setIdNumber(dto.getIdNumber());
        customerDetails.setDateOfBirth(dto.getDateOfBirth());
        customerDetails.setGender(dto.getGender());
        customerDetails.setCustomerStatus(dto.getCustomerStatus());

        return customerDetailsRepository.save(customerDetails);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    @Override
    public Optional<CustomerDetails> getCustomerDetailsById(Long customerId) {
        return customerDetailsRepository.findById(customerId);
    }

    @Override
    public Optional<CustomerDetails> updateCustomerDetails(Long customerId, CustomerDetailsDto dto) {

        if (!isValidPhoneNumber(dto.getPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

         return customerDetailsRepository.findById(customerId)
                .map(customerDetails1 -> {
                    customerDetails1.setFirstName(dto.getFirstName());
                    customerDetails1.setLastName(dto.getLastName());
                    customerDetails1.setPhoneNumber(dto.getPhoneNumber());
                    customerDetails1.setIdNumber(dto.getIdNumber());
                    customerDetails1.setDateOfBirth(dto.getDateOfBirth());
                    customerDetails1.setGender(dto.getGender());
                    customerDetails1.setRegisteredDate(dto.getRegisteredDate());
                    customerDetails1.setCustomerStatus(dto.getCustomerStatus());

                    return customerDetailsRepository.save(customerDetails1);
                });
    }

    private boolean isValidCustomerPhoneNumber(String customerPhoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(customerPhoneNumber);
        return matcher.matches();
    }

    @Override
    public Optional<Object> deleteCustomerDetails(Long customerId) {
        if (customerDetailsRepository.findById(customerId).isPresent()) {
            customerDetailsRepository.deleteById(customerId);
            return Optional.of("Customer is deleted successfully!");
        } else {
            return Optional.empty();
        }
    }
}
