package com.osiki.hibernatedemo.entites.model;

import com.osiki.hibernatedemo.entites.enums.Absent;
import com.osiki.hibernatedemo.entites.enums.Present;
import com.osiki.hibernatedemo.entites.enums.Reasons;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendance_tbl")
@Builder
public class Attendance extends BaseClass {

    @Enumerated(EnumType.STRING)
    private Present present;

    @Enumerated(EnumType.STRING)
    private Absent absent;

    @Enumerated(EnumType.STRING)
    private Reasons reasons;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
