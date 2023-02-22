package com.example.employee.controller.api;

import com.example.employee.business.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IEmployeeApi {
    String getEmployeeProfile(String name);
    void getEmployeeHeaderInformation(Map<String,String> headers);
    ResponseEntity<?> getEmployeeAppInformation(HttpServletResponse response, HttpServletRequest request);
    ResponseEntity<?> apiEmployeeCreate(EmployeeDto employeeDto);
    ResponseEntity<List<EmployeeDto>> apiEmployeeList();
    ResponseEntity<?> apiEmployeeFind(Long id);
    ResponseEntity<EmployeeDto> apiEmployeeUpdate(Long id, EmployeeDto employeeDto);
    ResponseEntity<Map<String,Boolean>> apiEmployeeDelete(Long id);

}
