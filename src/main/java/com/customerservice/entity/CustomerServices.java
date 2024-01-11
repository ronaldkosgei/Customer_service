package com.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_services")
public class CustomerServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "date_opted_in")
    @CreationTimestamp
    private LocalDate dateOptedIn;

    @Column(name = "account_opening_balance")
    private double accountOpeningBalance;
}
