package entitymapping.springdatajpa.business.concretes;

import entitymapping.springdatajpa.business.abstracts.EmployeeService;
import entitymapping.springdatajpa.entities.Employee;
import entitymapping.springdatajpa.entities.Address;
import entitymapping.springdatajpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor//Injection is made with this anotation
public class EmployeeManager implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        if (employee.getEmployeeName() == null) {
            throw new Exception("Employee name can not be empty!");
        }

        // Employee ile Address arasındaki ilişkiyi kurmak için
        List<Address> addresses = employee.getAddresses();
        if (addresses != null && !addresses.isEmpty()) {
            for (Address address : addresses) {
                address.setEmployee(employee);
            }
        }

        employeeRepository.save(employee);

    }


    @Override
    public Employee getEmployee(int id) throws Exception {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()){
            throw new Exception("There is no such Employee!");
        }
        return optionalEmployee.get();
    }

}
