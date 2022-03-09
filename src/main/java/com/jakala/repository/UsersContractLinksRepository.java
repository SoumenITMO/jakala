package com.jakala.repository;

import com.jakala.entities.UsersContractsRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersContractLinksRepository extends JpaRepository<UsersContractsRelation, Long> { }
