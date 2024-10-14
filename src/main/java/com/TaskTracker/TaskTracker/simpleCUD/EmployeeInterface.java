package com.TaskTracker.TaskTracker.simpleCUD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInterface extends JpaRepository<EmployeeModels, Long>, JpaSpecificationExecutor<EmployeeModels> {
}
