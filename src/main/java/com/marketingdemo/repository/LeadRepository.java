package com.marketingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingdemo.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
