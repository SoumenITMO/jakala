package com.jakala.entities;

import lombok.Data;
import java.util.Date;
import javax.persistence.*;

/**
 * This Entity responsible to handle contracts table
 */
@Data
@Entity
@Table(name = "contract")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "signed_by_provider")
    private Date signedByProvider;

    @Column(name = "contract_start_date")
    private Date startDate;

    @Column(name = "signed_by_consumer")
    private Date signedByConsumer;

    @Column(name = "contract_valid_upto")
    private Date contractValidUpto;

    @Column(name = "contract_content")
    private String contractData;

    @Column(name = "contract_type")
    private String contractType;

    @Column(name = "contract_valid")
    private Boolean contractValid;
}
