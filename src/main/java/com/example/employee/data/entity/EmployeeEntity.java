package com.example.employee.data.entity;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "employeeT")
public class EmployeeEntity extends BaseEntity implements Serializable {
    public static final Long serialVersionUID=1L;
    private String department;
    private String gender;
    private String username;
    private String surname;
    private String emailAdress;
    private String telephoneNumber;
    @Column(name = "password")
    private String passwd;

}
