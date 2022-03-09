package com.jakala.entities;

import lombok.Data;
import java.util.List;
import javax.persistence.*;

/**
 * This Entity responsible to handle users table
 */
@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "usertype")
    private String userType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "users_contract_links", joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "contract_id"))
    private List<ContractEntity> contracts;
}
