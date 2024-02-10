package com.example.repository;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Emploee;

public interface EmploeeRepository extends JpaRepository<Emploee, Long> {
    Collection<Emploee> findByJobTitle(String jobTitle);

    @Query("SELECT e FROM Emploee e WHERE e.salary > : minSalary")
    Collection<Emploee> findByMinSalary(@Param("minSalary") BigDecimal salary);
}
