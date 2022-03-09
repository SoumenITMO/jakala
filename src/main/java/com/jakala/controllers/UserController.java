package com.jakala.controllers;

import java.util.List;
import com.jakala.dtos.UserDto;
import com.jakala.entities.UserEntity;
import lombok.AllArgsConstructor;
import com.jakala.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller to handle users related requests and responses
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class UserController {

    private final UserService userService;

    /**
     * It accepts search criteria params and return matched user list
     * @param customerfirstname
     * @param customerlastname
     * @param customertype
     * @param contracttype
     * @param contractstartdate
     * @return matched user list according search criteria
     */
    @GetMapping("searchcontract")
    public ResponseEntity<List<UserDto>> getUsersBySearchedCriteria(@RequestParam(required = false)String customerfirstname,
                                                                    @RequestParam(required = false)String customerlastname,
                                                                    @RequestParam(required = false)String customertype,
                                                                    @RequestParam(required = false)String contracttype,
                                                                    @RequestParam(required = false)String contractstartdate) {

        return ResponseEntity.ok().body(userService.searchContractsByCriteria(customerfirstname, customerlastname, customertype,
                contracttype, contractstartdate));
    }

    /**
     * To fetch single user details with assigned contracts
     * @param userId which is requested to fetch user details
     * @return user details alone with contract
     * @throws Exception
     */
    @GetMapping("getuser/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id")Long userId) throws Exception {
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    /**
     *
     * @return all users including contracts
     */
    @GetMapping("allusers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
}
