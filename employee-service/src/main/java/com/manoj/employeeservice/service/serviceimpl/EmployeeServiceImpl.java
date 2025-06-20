package com.manoj.employeeservice.service.serviceimpl;

import com.manoj.employeeservice.dto.APIResponseDto;
import com.manoj.employeeservice.dto.DepartmentDto;
import com.manoj.employeeservice.dto.EmployeeDto;
import com.manoj.employeeservice.entity.Employee;
import com.manoj.employeeservice.feignclient.APIClient;
import com.manoj.employeeservice.mapper.EmployeeMapper;
import com.manoj.employeeservice.repository.EmployeeRepository;
import com.manoj.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    //private final RestTemplate restTemplate;

//    private WebClient webClient;
    private final APIClient apiClient;

    private final EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        //rest template call for getting department details of the employee
//       ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/departments/"+
//               employee.getDepartmentCode(), DepartmentDto.class);
//
//       DepartmentDto departmentDto = responseEntity.getBody();

        //using webclient for getting department details of the employee
//       DepartmentDto departmentDto =  webClient.get().uri("http://localhost:8080/api/v1/departments/"+ employee.getDepartmentCode())
//                .retrieve().bodyToMono(DepartmentDto.class)
//                .block();

        //using feign client
       DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        //setting all values into one dto

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
