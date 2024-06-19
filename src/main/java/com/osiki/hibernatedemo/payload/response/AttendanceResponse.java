package com.osiki.hibernatedemo.payload.response;

import com.osiki.hibernatedemo.entites.enums.Absent;
import com.osiki.hibernatedemo.entites.enums.Present;
import com.osiki.hibernatedemo.entites.enums.Reasons;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceResponse {
    private Present present;

    private Absent absent;

    private Reasons reasons;
}
