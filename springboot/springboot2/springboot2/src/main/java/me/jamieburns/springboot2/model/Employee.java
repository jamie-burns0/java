package me.jamieburns.springboot2.model;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Accessors(fluent=true) @Getter(onMethod = @__(@JsonProperty)) @NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.KebabCaseStrategy.class)
public class Employee {
    
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private String name;

    @Setter
    private String role;

    public Employee( String name, String role ) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{id=%d, name='%s', role='%s'}".formatted( id, name, role );
    }

    public static final Employee of( String name, String role )
    {
        return EmployeeSupport.newEmployee( name, role );
    }

    public static final Employee of( Employee employeeData )
    {
        return EmployeeSupport.newEmployee( employeeData.name(), employeeData.role() );
    }
}
