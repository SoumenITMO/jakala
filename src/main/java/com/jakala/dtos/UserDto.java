package com.jakala.dtos;

import lombok.Data;
import java.util.List;

@Data
public class UserDto {

    private String username;
    private String firstname;
    private String userType;
    private List<ContractDto> contracts;
}
