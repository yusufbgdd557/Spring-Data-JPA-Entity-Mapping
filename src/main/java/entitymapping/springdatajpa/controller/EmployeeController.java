package entitymapping.springdatajpa.controller;

import entitymapping.springdatajpa.business.abstracts.EmployeeService;
import entitymapping.springdatajpa.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    //This reference is injected with *@RequiredArgsConstructor* anotation instead of constructor based injection.
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }
    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee) throws Exception {
        this.employeeService.addEmployee(employee);
    }
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable int id) throws Exception {
        return employeeService.getEmployee(id);
    }

}
