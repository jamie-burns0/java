package me.jamieburns.springboot2.controller;

import static me.jamieburns.springboot2.model.EmployeeSupport.updatEmployee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import me.jamieburns.springboot2.model.Employee;
import me.jamieburns.springboot2.model.EmployeeRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/employees")
    List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee( @RequestBody Employee newEmployee) {
        return repository.save( newEmployee );
    }
    
    @GetMapping("/employees/{id}")
    Employee findEmployee( @PathVariable Long id ) {
        return 
            repository.findById( id )
                      .orElseThrow( () -> new RuntimeException( "Cannot find employee [id=%s]".formatted( id ) ) );
    }
    
    @PutMapping("/employees/{id}")
    Employee replaceEmployee( @RequestBody Employee employeeData, @PathVariable Long id ) {
        
        var employee = 
            repository.findById( id )
                      .map( existingEmployee -> updatEmployee( existingEmployee , employeeData ) )
                      .orElse( Employee.of( employeeData ) );

        return repository.save( employee );
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee( @PathVariable Long id ) {
        repository.deleteById( id );
    }
}
