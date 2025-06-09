package com.manoj.departmentservice.service.serviceimpl;

import com.manoj.departmentservice.dto.DepartmentDto;
import com.manoj.departmentservice.entity.Department;
import com.manoj.departmentservice.mapper.DepartmentMapper;
import com.manoj.departmentservice.repository.DepartmentRepository;
import com.manoj.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

//    @Override
//    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//        );
//
//       Department savedDepartment = departmentRepository.save(department);
//       DepartmentDto savedDepartmentDto = new DepartmentDto(
//               savedDepartment.getId(),
//               savedDepartment.getDepartmentName(),
//               savedDepartment.getDepartmentDescription(),
//               savedDepartment.getDepartmentCode()
//       );
//        return savedDepartmentDto;
//    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}
