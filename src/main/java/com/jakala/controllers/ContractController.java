package com.jakala.controllers;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import com.jakala.dtos.ContractDto;
import com.jakala.services.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller to handle contracts related requests and responses
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class ContractController {

    private final ContractService contracrService;

    /**
     *
     * @param contractDto requested contract data
     * @param uid requested user id which will be linked with the user
     * @return void
     * @throws Exception when there will be no user exists with the given user id
     */
    @PostMapping("createcontract")
    public ResponseEntity<Void> createNewContract(@Valid @RequestBody ContractDto contractDto,
                                                  @RequestParam Long uid) throws Exception {

        contracrService.createNewContract(contractDto, uid);
        return ResponseEntity.noContent().build();
    }
}
