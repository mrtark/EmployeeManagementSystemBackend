package com.example.employee.business.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class EmployeeDto {
    private Long id;
    @NotNull(message = "{employee.department.validation.constraints.NotNull.message}")
    private String department;
    @NotNull(message = "{employee.gender.validation.constraints.NotNull.message}")
    private String gender;
    @NotNull(message = "{employee.username.validation.constraints.NotNull.message}")
    private String username;
    @NotNull(message = "{employee.surname.validation.constraints.NotNull.message}")
    private String surname;
    @NotNull(message = "{employee.email.validation.constraints.NotNull.message}")
    @Email(message = "{employee.email.validation.constraints.property.message}")
    @Size(max = 80, message = "{employee.email.validation.constraints.max.message}")
    private String emailAdress;
    @NotNull(message = "{employee.telephone.validation.constraints.NotNull.message}")
    @Pattern(regexp = "^(\\+\\d{9,0}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$",
            message = "{employee.telephone.validation.constraints.pattern.regex.message}")
    private String telephoneNumber;
    @NotNull(message = "{employee.password.validation.constraints.NotNull.message}")
    @Pattern(regexp = " ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
            message = "{employee.password.validation.constraints.pattern.regex.message}")
    private String passwd;
    private Date createDate;

}
