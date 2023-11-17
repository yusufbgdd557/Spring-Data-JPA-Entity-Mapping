package entitymapping.springdatajpa.business.abstracts;

import entitymapping.springdatajpa.entities.Employee;


import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void addEmployee(Employee employee) throws Exception;
    Employee getEmployee(int id) throws Exception;
}
