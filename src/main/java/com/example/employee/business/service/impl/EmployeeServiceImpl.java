package com.example.employee.business.service.impl;

import com.example.employee.bean.ModelMapperB;
import com.example.employee.bean.PasswordEncoder;
import com.example.employee.business.dto.EmployeeDto;
import com.example.employee.business.service.IEmployeeService;
import com.example.employee.data.entity.EmployeeEntity;
import com.example.employee.data.repository.IEmployeeRepository;
import com.example.employee.exception.ResourceNotFoundApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Log4j2
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeRepository iEmployeeRepository;
    private final ModelMapperB modelMapperB;
    private final PasswordEncoder passwordEncoder;
    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        return modelMapperB.modelMapperMethod().map(employeeEntity, EmployeeDto.class);
    }

    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        return modelMapperB.modelMapperMethod().map(employeeDto, EmployeeEntity.class);
    }

    @Override
    @Transactional
    public EmployeeDto employeeCreate(EmployeeDto employeeDto) {
        employeeDto.setPasswd(passwordEncoder.passwordEncoderMethod().encode(employeeDto.getPasswd()));
        EmployeeEntity createAddEntity = iEmployeeRepository.save(DtoToEntity(employeeDto));
        employeeDto.setId(createAddEntity.getId());
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> employeeList() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        List<EmployeeEntity> employeeEntityList = iEmployeeRepository.findAll();
        for ( EmployeeEntity choose: employeeEntityList ) {
            EmployeeDto dtoData = EntityToDto(choose);
            employeeDtoList.add(dtoData);
        }
        return employeeDtoList;
    }

    @Override
    public EmployeeDto employeeFind(Long id) {
        EmployeeEntity dataFound = iEmployeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundApiException("{" + id + "}" + " ID Data Not Found!"));
        EmployeeDto dataFoundDto = EntityToDto(dataFound);
        return dataFoundDto;
    }

    @Override
    @Transactional
    public EmployeeDto employeeUpdate(Long id, EmployeeDto employeeDto) {
        EmployeeDto foundDto = employeeFind(id);
        if (foundDto!=null){
            foundDto.setDepartment(employeeDto.getDepartment());
            foundDto.setGender(employeeDto.getGender());
            foundDto.setUsername(employeeDto.getUsername());
            foundDto.setSurname(employeeDto.getSurname());
            foundDto.setEmailAdress(employeeDto.getEmailAdress());
            foundDto.setTelephoneNumber(employeeDto.getTelephoneNumber());
            EmployeeEntity updateEntity = iEmployeeRepository.save(DtoToEntity(foundDto));
            iEmployeeRepository.save(updateEntity);
            foundDto.setId(updateEntity.getId());
            log.info(foundDto.getId() + ": ID Data Update Success.");
            return foundDto;
        }
        return null;
    }

    @Override
    @Transactional
    public Map<String, Boolean> employeeDelete(Long id) {
        EmployeeDto foundDto = employeeFind(id);
        Map<String,Boolean> employeeDeleted = new LinkedHashMap<>();
        if (foundDto!=null){
            iEmployeeRepository.delete(DtoToEntity(foundDto));
            employeeDeleted.put(foundDto + " Data is Permanently Deleted!", Boolean.TRUE);
        }
        return employeeDeleted;
    }
}
