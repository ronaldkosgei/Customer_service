package com.customerservice.service.impl;

import com.customerservice.dto.CustomerServicesDto;
import com.customerservice.entity.CustomerServices;
import com.customerservice.repository.CustomerServicesRepository;
import com.customerservice.service.CustomerServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerServicesServiceImpl implements CustomerServicesService {

    private static final String CUSTOMER_PHONE_NUMBER_REGEX = "^(2547\\d{8}|07\\d{8}|7\\d{8})$";

    private CustomerServicesRepository customerServicesRepository;

    public CustomerServicesServiceImpl(CustomerServicesRepository customerServicesRepository) {
        this.customerServicesRepository = customerServicesRepository;
    }

    @Override
    public CustomerServices saveCustomerServices(CustomerServicesDto dto) {

        if (!isValidCustomerPhoneNumber(dto.getCustomerPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

        CustomerServices customerServices = new CustomerServices();
        customerServices.setCustomerPhoneNumber(dto.getCustomerPhoneNumber());
        customerServices.setServiceType(dto.getServiceType());
        customerServices.setDateOptedIn(dto.getDateOptedIn());
        customerServices.setAccountOpeningBalance(dto.getAccountOpeningBalance());

        return customerServicesRepository.save(customerServices);

    }

    private boolean isValidCustomerPhoneNumber(String customerPhoneNumber) {
        Pattern pattern = Pattern.compile(CUSTOMER_PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(customerPhoneNumber);
        return matcher.matches();


}

    @Override
    public Optional<CustomerServices> getCustomerServicesById(Long customerServicesId) {
        return customerServicesRepository.findById(customerServicesId);
    }

    @Override
    public Optional<CustomerServices> updateCustomerServices(Long customerServicesId, CustomerServicesDto dto) {

        if (!isValidCustomerPhoneNumber(dto.getCustomerPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

            return customerServicesRepository.findById(customerServicesId)
                    .map(customerServices1 -> {
                        customerServices1.setCustomerPhoneNumber(dto.getCustomerPhoneNumber());
                        customerServices1.setServiceType(dto.getServiceType());
                        customerServices1.setDateOptedIn(dto.getDateOptedIn());
                        customerServices1.setAccountOpeningBalance(dto.getAccountOpeningBalance());

                        return customerServicesRepository.save(customerServices1);
                    });
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(CUSTOMER_PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    @Override
    public Optional<Object> deleteCustomerServices(Long customerServicesId) {
        if (customerServicesRepository.findById(customerServicesId).isPresent()) {
            customerServicesRepository.deleteById(customerServicesId);
            return Optional.of("Customer Services deleted successfully");
        } else {
            return Optional.empty();
        }
    }
}
