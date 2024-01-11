package com.customerservice.repository;

import com.customerservice.entity.CustomerServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServicesRepository extends JpaRepository<CustomerServices, Long> {
}
