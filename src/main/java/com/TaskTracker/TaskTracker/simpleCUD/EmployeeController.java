package com.TaskTracker.TaskTracker.simpleCUD;

import com.TaskTracker.TaskTracker.core.ApiResponse;
import com.TaskTracker.TaskTracker.core.CustomRequestException;
import com.TaskTracker.TaskTracker.core.PaginationUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeService employeService;

    //Add data employee
    @PostMapping
    public EmployeeModels createEmployee(@RequestBody @Valid EmployeeDTO request){
        return employeService.createEmployee(request);
    }

    //Update data employee by id
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModels> updateEmployee(@PathVariable ("id")Long id, @Valid @RequestBody EmployeeDTO request){
        return ResponseEntity.ok(employeService.updateEmployee(id, request));
    }

    //Delete data employee by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        employeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchEmployee(EmployeeRequestDTO searchDTO){
        try {
            PaginationUtil<EmployeeModels, EmployeeModels> result = employeService.getAllEmployeeByPagination(searchDTO);
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK, "Success retrieved data", result), HttpStatus.OK);
        }catch (CustomRequestException err){
            return err.GlobalCustomRequestException(err.getMessage(), err.getStatus());
        }
    }
}
