package com.customerservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CustomerServicesDto {

    @Id
    private Long serviceId;

    private String customerPhoneNumber;

    private String serviceType;

    @NotNull
    private LocalDate dateOptedIn;

    private double accountOpeningBalance;
}
