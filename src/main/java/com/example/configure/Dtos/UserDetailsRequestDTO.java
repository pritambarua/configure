package com.example.configure.Dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserDetailsRequestDTO {

    @NonNull
    private String fName;

    @NonNull
    private String lName;

    private String emailId;
}
