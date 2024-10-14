package com.TaskTracker.TaskTracker.simpleCUD;

import com.TaskTracker.TaskTracker.core.PaginationUtil;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeService {
    @Autowired
    private EmployeeInterface employeeInterface;
    public EmployeeModels createEmployee(EmployeeDTO request) {
        try {
            EmployeeModels data = EmployeeModels.builder()
                    .id(request.getId())
                    .description(request.getDescription())
                    .status(request.getStatus())
                    .createdAt(request.getCreatedAt())
                    .updatedAt(request.getUpdatedAt())
                    .build();
            return employeeInterface.save(data);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public EmployeeModels updateEmployee(Long id, EmployeeDTO request) {
        try {
            EmployeeModels data = employeeInterface.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));
            data.setDescription(request.getDescription());
            data.setStatus(request.getStatus());
            return employeeInterface.save(data);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteEmployee(Long id) {
        EmployeeModels findData = employeeInterface.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        employeeInterface.delete(findData);
    }

    public PaginationUtil<EmployeeModels, EmployeeModels> getAllEmployeeByPagination(EmployeeRequestDTO searchDTO) {
        Specification<EmployeeModels> specification = (root, query, builder)->{
            List<Predicate> predicates = new ArrayList<>();

            //search by status
            if (searchDTO.getStatus() != null && !searchDTO.getStatus().isEmpty()) {
                predicates.add(
                        builder.in(root.get("status")).value(searchDTO.getStatus())
                );
            }
            return Objects.requireNonNull(query).where(predicates.toArray(new Predicate[]{})).getRestriction();
        };
        Pageable paging = PageRequest.of(searchDTO.getPage()-1 , searchDTO.getSize());
        Page<EmployeeModels> pagedResult = employeeInterface.findAll(specification, paging);
        return new PaginationUtil<>(pagedResult, EmployeeModels.class);
    }
}
