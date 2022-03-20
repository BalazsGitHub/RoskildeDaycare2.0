
package com.example.myfirstapplication.common;

import com.example.myfirstapplication.children.Children;
import com.example.myfirstapplication.children.ChildrenService;
import com.example.myfirstapplication.schedule.Employee;
import com.example.myfirstapplication.schedule.EmployeeService;
import com.example.myfirstapplication.schedule.ScheduleService;
import com.example.myfirstapplication.user.User;
import com.example.myfirstapplication.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class InitialData {

    @Autowired
    UserService userService;


    @Autowired
    EmployeeService employeeService;

    @Autowired
    ChildrenService childrenService;

    @PostConstruct
    public void initialiseDatabase(){
        User user = new User("SandraAdmin", "admin123", "Sandra", "Bullok");
        userService.saveUser(user);

        Employee employee1 = new Employee("John", "+545444554", "Some street");
        Employee employee2 = new Employee("Tom", "+178754847", "Some street");
        Employee employee3 = new Employee("Anna", "+487874545", "Some street");

        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);
        employeeService.saveEmployee(employee3);

        Children children1 = new Children("Laura", "some street", "459595");

        childrenService.saveChildren(children1);
    }
}
