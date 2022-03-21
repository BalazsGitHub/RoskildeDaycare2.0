
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

    @PostConstruct
    public void initialiseDatabase(){
        User user = new User("SandraAdmin", "admin123");
      userService.saveUser(user);

         Employee employee1 = new Employee("Tom", "Adams", "Some street", "+453939393");
         Employee employee2 = new Employee("Daniel", "Szabo", "Some street", "+453934493");
         Employee employee3 = new Employee("Mette", "Sørensen", "Gadevej 45", "+4531233443");
         Employee employee4 = new Employee("Sanna", "Svensson", " FikaGata 41", "+45567493");
         Employee employee5 = new Employee("Anitta", "Otz", " Gladestræde 15" , "+45596493");

          employeeService.saveEmployee(employee1);
          employeeService.saveEmployee(employee2);
          employeeService.saveEmployee(employee3);
          employeeService.saveEmployee(employee4);
          employeeService.saveEmployee(employee5);


          Children children1 = new Children("Laura", "Thomasen", "David", "Thomasen", "Absalonsgade 1", "+452239239");
          Children children2 = new Children("Emma", "Larsen", "Mads", "Larsen", "Elmegade 23", "+452392739");
          Children children3 = new Children("Lasse", "Petersen", "Pia", "Petersen", "Carlsbergvej 45", "+458345763");
          Children children4 = new Children("Vilma", "Dombovari", "Niels", "Dombovari", "Tuborgvej 3", "+4534654523");
          Children children5 = new Children("Maja", "Wickman", "Birthe", "Wickman", "Heinekenhavn 66 ", "+4523439070");
          Children children6 = new Children("Freddy", "Jones", "Otto", "Jones", "Nyhavn 8", "+45239768594");
          Children children7 = new Children("Mark", "Jolie", "Margit", "Jolie", "H.C.Andersens boulevard 30 ", "+4522392039");
          Children children8 = new Children("Thor", "Pitt", "Bea", "Pitt", "Roskildevej 1", "+4560604530");
          Children children9 = new Children("Roberto", "Carlos", "Elek", "Carlos", "Frederiksberg Allé 83", "+4513340045");
          Children children10 = new Children("Villads", "Matisse", "Doris", "Matisse", "Guldbergsgade 2", "+4520304050");
          Children children11= new Children("Kalle", "Pedersen", "Joao", "Pedersen", "Rosenvængets Allé 6", "+4510203040");
          childrenService.saveChildren(children1);
          childrenService.saveChildren(children2);
          childrenService.saveChildren(children3);
          childrenService.saveChildren(children4);
          childrenService.saveChildren(children5);
          childrenService.saveChildren(children6);
          childrenService.saveChildren(children7);
          childrenService.saveChildren(children8);
          childrenService.saveChildren(children9);
          childrenService.saveChildren(children10);
          childrenService.saveChildren(children11);
    }
  }

