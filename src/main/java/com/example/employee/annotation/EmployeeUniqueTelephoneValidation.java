package com.example.employee.annotation;

import com.example.employee.data.entity.EmployeeEntity;
import com.example.employee.data.repository.IEmployeeRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class EmployeeUniqueTelephoneValidation implements ConstraintValidator<EmployeeUniqueTelephone,String> {
    private final IEmployeeRepository iEmployeeRepository;

    @Override
    public boolean isValid(String telephone, ConstraintValidatorContext constraintValidatorContext) {
        EmployeeEntity employeeEntity = iEmployeeRepository.findByTelephoneNumber(telephone);
        if (employeeEntity!=null){
            return false;
        }
        return true;
    }
}
