package com.example.employee.business.dto;

import com.example.employee.annotation.EmployeeUniqueEmail;
import com.example.employee.annotation.EmployeeUniqueTelephone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
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
    @EmployeeUniqueEmail
    private String emailAdress;
    @NotNull(message = "{employee.telephone.validation.constraints.NotNull.message}")
    @Pattern(regexp = "^(\\+\\d{1,2}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "{employee.telephone.validation.constraints.pattern.regex.message}")
    @EmployeeUniqueTelephone
    private String telephoneNumber;
    @NotNull(message = "{employee.password.validation.constraints.NotNull.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
           message = "{employee.password.validation.constraints.pattern.regex.message}")
    private String passwd;
    private Date createDate;

}
