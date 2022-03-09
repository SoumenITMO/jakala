package com.jakala.services;

import lombok.AllArgsConstructor;
import com.jakala.dtos.ContractDto;
import com.jakala.mappers.ContractMapper;
import com.jakala.entities.ContractEntity;
import com.jakala.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.jakala.repository.ContractRepository;
import com.jakala.entities.UsersContractsRelation;
import com.jakala.repository.UsersContractLinksRepository;

/**
 * This service class is responsible to process user contracts related requests
 */
@Service("contract")
@AllArgsConstructor
public class ContractService {

    private final UserRepository userRepository;
    private final ContractMapper contractMapper;
    private final ContractRepository contractRepository;
    private final UsersContractLinksRepository usersContractLinksRepository;

    /**
     *
     * @param contractDto requested contract to create using existed user
     * @throws Exception
     */
    public void createNewContract(ContractDto contractDto, Long userId) throws Exception {
        userRepository.findById(userId).orElseThrow(() -> new Exception("User # " + userId + " not found"));
        ContractEntity contractEntity = contractRepository.save(contractMapper.toContractEntity(contractDto));
        usersContractLinksRepository.save(new UsersContractsRelation(0L, userId, contractEntity.getId()));
    }
}
