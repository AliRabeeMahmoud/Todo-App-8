package com.ali.java.todo.dto;

import com.ali.java.todo.validation.ValidateAgeType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateUserDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String userName;

    @NotBlank
    @Size(min = 4, max = 12)
    private String password;

    @ValidateAgeType
    private String ageType;  //child, teenager, adult, old


    //next phase, make another enum field for validation
}
