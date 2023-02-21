package com.example.employee.annotation;

import com.example.employee.data.entity.EmployeeEntity;
import com.example.employee.data.repository.IEmployeeRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@RequiredArgsConstructor
public class EmployeeUniqueEmailValidation implements ConstraintValidator<EmployeeUniqueEmail,String> {
    private final IEmployeeRepository iEmployeeRepository;
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        EmployeeEntity employeeEntity = iEmployeeRepository.findByEmailAdress(email);
        if (employeeEntity!=null){
            return false;
        }
        return true;
    }
}
