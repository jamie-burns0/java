package me.jamieburns.springboot2.model;

public class EmployeeSupport {

    public static final Employee newEmployee( String name, String role )
    {
        return new Employee( name, role );
    }
    
    public static final Employee updatEmployee( Employee employeeToUpdate, Employee employeeWithUpdatedData )
    {        
        employeeToUpdate.name( employeeWithUpdatedData.name() );
        employeeToUpdate.role( employeeWithUpdatedData.role() );
        return employeeToUpdate;
    }
}
