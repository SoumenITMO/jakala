package com.jakala.services;

import com.jakala.dtos.UserDto;
import lombok.AllArgsConstructor;
import com.jakala.mappers.UserMapper;
import com.jakala.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This service is responsible to process user related requests
 */
@Service("user")
@AllArgsConstructor
public class UserService {

    private UserMapper userMapper;
    private List<UserDto> searchedResult;
    private UserRepository userRepository;

    /**
     *
     * @param customerFirstName
     * @param customerType
     * @param contractType
     * @param contractValidFrom
     * @return Users list
     */
    public List<UserDto> searchContractsByCriteria(String customerFirstName, String customerLastName, String customerType,
                                                   String contractType, String contractValidFrom) {
        searchedResult = userRepository.searchByCreteria(customerFirstName, customerLastName, customerType, contractType, contractValidFrom)
                .stream()
                .distinct()
                .map(userMapper::toUser).collect(Collectors.toList());
        return searchedResult;
    }

    /**
     *
     * @param userId
     * @return requested user data by user id
     * @throws Exception
     */
    public UserDto getUserById(Long userId) throws Exception {
        return userMapper.toUser(userRepository.findById(userId).orElseThrow(() ->
                new Exception("User # "+ userId +" not found")));
    }

    /**
     *
     * @return all users with contracts
     */
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUser).collect(Collectors.toList());
    }
}
