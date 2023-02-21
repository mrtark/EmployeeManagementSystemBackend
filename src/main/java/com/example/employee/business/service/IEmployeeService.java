package com.example.employee.business.service;

import com.example.employee.business.dto.EmployeeDto;
import com.example.employee.data.entity.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity);
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto);
    public EmployeeDto employeeCreate(EmployeeDto employeeDto);
    public List<EmployeeDto> employeeList();
    public EmployeeDto employeeFind(Long id);
    public EmployeeDto employeeUpdate(Long id, EmployeeDto employeeDto);
    public Map<String,Boolean> employeeDelete(Long id);
}
