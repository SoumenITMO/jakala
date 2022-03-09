package com.jakala.mappers;

import org.mapstruct.Mapper;
import com.jakala.dtos.ContractDto;
import com.jakala.entities.ContractEntity;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    ContractEntity toContractEntity(ContractDto contractDto);
}
