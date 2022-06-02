package com.letscode.usersapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String profile;
    private LocalDate birthDate;

}
