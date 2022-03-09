package com.jakala.dtos;

import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;

@Data
public class ContractDto {

    @NotNull(message = "invalid signed by contract provider")
    private Date signedByProvider;

    @NotNull(message = "invalid start date")
    private Date startDate;

    @NotNull(message = "invalid signed by consumer date")
    private Date signedByConsumer;

    @NotNull(message = "Invalid contract valid up to date")
    private Date contractValidUpto;

    @NotNull(message = "Contract data can not be null")
    private String contractData;

    @NotNull(message = "Contract type can not be null")
    @Pattern(regexp = "GAS|ELECTRICITY|GAS & ELECTRICITY", message = "Invalid input")
    private String contractType;
}
