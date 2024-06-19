package com.osiki.hibernatedemo.payload.request;

import com.osiki.hibernatedemo.entites.enums.Designation;
import com.osiki.hibernatedemo.entites.enums.Gender;
import com.osiki.hibernatedemo.entites.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "First name cannot be blank")
    private String lastName;

    @Email(message = "Must be a valid email")
    @NotBlank(message = "Email should not be blank!")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    @Enumerated(EnumType.STRING)
    private Gender gender;


}
