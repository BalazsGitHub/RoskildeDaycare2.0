
package com.teletearbies.roskildedaycare.common;

import com.teletearbies.roskildedaycare.entity.Children;
import com.teletearbies.roskildedaycare.service.ChildrenService;
import com.teletearbies.roskildedaycare.entity.Employee;
import com.teletearbies.roskildedaycare.service.EmployeeService;
import com.teletearbies.roskildedaycare.entity.User;
import com.teletearbies.roskildedaycare.service.UserService;
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

    //@PostConstruct
   // public void initialiseDatabase(){
      //  User user = new User("SandraAdmin", "admin123");
    //    userService.saveUser(user);

  //      Employee employee1 = new Employee("Tom", "Adams", "Some street", "+453939393");
//        Employee employee2 = new Employee("Daniel", "Szabo", "Some street", "+453934493");

        //employeeService.saveEmployee(employee1);
       // employeeService.saveEmployee(employee2);


     //   Children children1 = new Children("Laura", "Thomasen", "David", "Thomasen", "Some street", "+5522392i39");
   //     childrenService.saveChildren(children1);
    }
//}
