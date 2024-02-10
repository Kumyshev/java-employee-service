package com.example.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Emploee;
import com.example.repository.EmploeeRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/emploees")
public class EmploeeController {
    @Autowired
    private EmploeeRepository repository;

    @GetMapping
    public Collection<Emploee> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Emploee> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Emploee create(@RequestBody Emploee emploee) {
        return repository.save(emploee);
    }

    @GetMapping("/find/jobTitle/{jobTitle}")
    public Collection<Emploee> findByJobTitle(@PathVariable String jobTitle) {
        return repository.findByJobTitle(jobTitle);
    }

    @GetMapping("/find/minSalary/{minSalary}")
    public Collection<Emploee> findByMinSalary(@PathVariable BigDecimal minSalary) {
        return repository.findByMinSalary(minSalary);
    }
    
}
