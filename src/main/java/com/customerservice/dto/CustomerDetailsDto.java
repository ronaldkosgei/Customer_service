package com.customerservice.dto;

import com.customerservice.enums.CustomerStatus;
import com.customerservice.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class CustomerDetailsDto {


    private Long customerId;

    @NotEmpty(message = "Phone number is required")
    private String phoneNumber;

    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "ID number is required")
    private int idNumber;

    private LocalDate dateOfBirth;

    private Gender gender;

    @NotNull
    private LocalDateTime registeredDate;

    @NotNull
    private CustomerStatus customerStatus;

}
