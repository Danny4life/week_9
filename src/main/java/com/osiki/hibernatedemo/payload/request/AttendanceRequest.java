package com.osiki.hibernatedemo.payload.request;

import com.osiki.hibernatedemo.entites.enums.Absent;
import com.osiki.hibernatedemo.entites.enums.Present;
import com.osiki.hibernatedemo.entites.enums.Reasons;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceRequest {


    @Enumerated(EnumType.STRING)
    private Present present;


    @Enumerated(EnumType.STRING)
    private Absent absent;


    @Enumerated(EnumType.STRING)
    private Reasons reasons;
}
