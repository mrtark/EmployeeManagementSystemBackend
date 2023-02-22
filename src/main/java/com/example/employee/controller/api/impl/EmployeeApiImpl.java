package com.example.employee.controller.api.impl;

import com.example.employee.business.dto.EmployeeDto;
import com.example.employee.business.service.IEmployeeService;
import com.example.employee.controller.api.IEmployeeApi;
import com.example.employee.error.ApiConclusion;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("employee")
@CrossOrigin(origins = "http://localhost:5555")
public class EmployeeApiImpl implements IEmployeeApi {
    private final IEmployeeService iEmployeeService;

    @Override
    public String getEmployeeProfile(String name) {
        return null;
    }

    @Override
    public void getEmployeeHeaderInformation(Map<String, String> headers) {

    }

    @Override
    public ResponseEntity<?> getEmployeeAppInformation(HttpServletResponse response, HttpServletRequest request) {
        return null;
    }

    @Override
    @PostMapping("apiEmployeeCreate")
    public ResponseEntity<?> apiEmployeeCreate(@Valid @RequestBody EmployeeDto employeeDto) {
        iEmployeeService.employeeCreate(employeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    @Override
    @GetMapping(value = "apiEmployeeList")
    public ResponseEntity<List<EmployeeDto>> apiEmployeeList() {
        return ResponseEntity.ok(iEmployeeService.employeeList());
    }

    @Override
    @GetMapping({"", "/{id}"})
    public ResponseEntity<?> apiEmployeeFind(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            log.error("404 Not Found!");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request!");
            return ResponseEntity.badRequest().body("Bad Request! Please check.");
        } else if (id < 0) {
            log.error("400 Bad Request!");
            ApiConclusion apiConclusion = ApiConclusion.builder()
                    .path("/employee/")
                    .message("ID cannot be less than zero.")
                    .status(400)
                    .build();
            return ResponseEntity.status(400).body(apiConclusion);
        } else if (id == -1) {
            log.error("401 unAuthorized");
            ApiConclusion apiConclusion = ApiConclusion.builder()
                    .path("/employee/")
                    .message("unAuthorized entry")
                    .status(401)
                    .build();
            return ResponseEntity.status(401).body(apiConclusion);
        }
        log.info("Found Data: " + iEmployeeService.employeeFind(id));
        return ResponseEntity.ok(iEmployeeService.employeeFind(id));
    }

    @Override
    @PutMapping({"", "/{id}"})
    public ResponseEntity<EmployeeDto> apiEmployeeUpdate(@PathVariable(name = "id",required = false)
                                                             @Valid @RequestBody Long id, EmployeeDto employeeDto) {
        if (id == null) {
            log.error("404 Not Found!");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request!");
            return ResponseEntity.badRequest().build();
        }
        EmployeeDto data =(EmployeeDto) iEmployeeService.employeeUpdate(id,employeeDto);
        log.info("Found Data: " + data);
        return ResponseEntity.ok(data);
    }

    @Override
    @DeleteMapping({"", "/{id}"})
    public ResponseEntity<Map<String, Boolean>> apiEmployeeDelete(@PathVariable Long id) {
        if (id == null) {
            log.error("404 Not Found!");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request!");
            return ResponseEntity.badRequest().build();
        }
        log.info("Deleted Found Data: " + iEmployeeService.employeeFind(id));
        iEmployeeService.employeeDelete(id);
        Map<String, Boolean> response = new LinkedHashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
