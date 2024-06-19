package com.osiki.hibernatedemo.payload.response;

import com.osiki.hibernatedemo.entites.enums.Designation;
import com.osiki.hibernatedemo.entites.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

    private Designation designation;


}
