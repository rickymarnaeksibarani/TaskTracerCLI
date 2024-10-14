package com.TaskTracker.TaskTracker.simpleCUD;

import com.TaskTracker.TaskTracker.core.StatusEmployee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeRequestDTO {
    private Integer page;
    private Integer size;
    private String searchTerm;
    private List<StatusEmployee> status;

    EmployeeRequestDTO(){
        if (this.getPage()==null){
            this.page = 1;
        }
        if (this.getSize()==null){
            this.size = 10;
        }
    }
}
