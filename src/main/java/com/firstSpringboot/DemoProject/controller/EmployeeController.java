package com.firstSpringboot.DemoProject.controller;

import com.firstSpringboot.DemoProject.bean.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    // http://localhost:8080/employee
    @GetMapping("employee")
    public ResponseEntity<Employee> getEmployee() {
        Employee employee = new Employee(100000, "Divya", "Konchada");
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    // http://localhost:8080/employees
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1000.00, "Divya", "Konchada"));
        employees.add(new Employee(100000, "Nainika", "Munasala"));
        employees.add(new Employee(100000, "Tayez", "Konchada"));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    // Springboot Rest API with path Variable
    // {salary} URI template variable
    // http://localhost:8080/employees/1000
    @GetMapping("{salary}")
    public ResponseEntity<Employee> employeePathVariable(@PathVariable("salary") int employeesalary) {
        Employee employee = new Employee(employeesalary, "Divya",  "Konchada");
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    //for multiple path variables
    //http://localhost:8080/employees/20/divya/konchada
    @GetMapping("{salary}/{first-name}/{last-name}")
    public ResponseEntity<Employee> employeePathVariable(@PathVariable("salary") int employeesalary,
                                         @PathVariable("first-name") String firstName,
                                         @PathVariable("last-name") String lastName) {
        Employee employee = new Employee(employeesalary, firstName, lastName);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Spring boot Rest API with Request Param
    //http://localhost:8080/employees/query?salary=100
    @GetMapping("query")
    public ResponseEntity<Employee> employeeRequestVariable(@RequestParam int salary) {
        Employee employee = new Employee(salary, "Divya", "Konchada");
        return ResponseEntity.ok(employee);
    }

    // for multiple query parameters
    //http://localhost:8080/employees/multiplequeryparams?salary=100.00&firstName=Divya&lastName=Konchada
    @GetMapping("multiplequeryparams")
    public ResponseEntity<Employee> employeeRequestVariable(@RequestParam double salary,

                                            @RequestParam String firstName,
                                            @RequestParam String lastName) {
         Employee employee = new Employee(salary, firstName, lastName);
         return ResponseEntity.ok(employee);

    }

    //Springboot REST API that handles HTTP POST-creating new resource
    //http://localhost:8080/employees/create
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        System.out.println(employee.getSalary());
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
// Springboot REST API that handles HTTP PUT Request-updating the existing resource
    @PutMapping("{salary}/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("salary") double salary) {
        System.out.println(employee.getLastName());
        System.out.println(employee.getFirstName());
        return ResponseEntity.ok(employee);
    }
    //springboot REST API that handles HTTP DELETE Request-Deleting the existing resource
    @DeleteMapping("{salary}/delete")
    public ResponseEntity<String> deleteEmployee(@PathVariable double salary) {
        System.out.println(salary);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
