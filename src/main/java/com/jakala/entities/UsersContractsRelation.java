package com.jakala.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_contract_links")
public class UsersContractsRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "users_id")
    private Long userId;

    @Column(name = "contract_id")
    private Long contractId;
}
