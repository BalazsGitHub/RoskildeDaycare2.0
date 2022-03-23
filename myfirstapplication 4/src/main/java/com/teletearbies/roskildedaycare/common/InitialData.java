
package com.teletearbies.roskildedaycare.common;

import com.teletearbies.roskildedaycare.entity.*;
import com.teletearbies.roskildedaycare.service.*;
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

    @Autowired
    WaitingListService waitingListService;

    @Autowired
    ScheduleService scheduleService;

/*   @PostConstruct
    public void initialiseDatabase() {
        User user1 = new User("SandraAdmin", "admin123");
        User user2 = new User("Bobman", "coolman");
        User user3 = new User("Susan71", "mean71");
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        Employee employee1 = new Employee("Bob", "Kind", "Kindle street 21.", "+453939393");
        Employee employee2 = new Employee("Susan", "Mean", "Tarnished road 1.", "+453934493");
        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);
        Schedule schedule1 = new Schedule("Bob Kind","8:00 - 12:00", "08:00 - 12:00", "12:00 - 16:00", "12:00 - 12:00", "Day off");
        Schedule schedule2 = new Schedule("Susan Mean","12:00 - 16:00", "12:00 - 16:00", "Day off", "12:00 - 16:00", "08:00 - 16:00");
        scheduleService.saveSchedule(schedule1);
        scheduleService.saveSchedule(schedule2);
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
        Children children11 = new Children("Kalle", "Pedersen", "Joao", "Pedersen", "Rosenvængets Allé 6", "+4510203040");
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
        WaitingList waitingList1 = new WaitingList("Tim", "Waiter", "Morten", "Waiter", "Liongade 6.", "+450419259");
        WaitingList waitingList2 = new WaitingList("Sophia", "Rock", "Millie", "Rock", "Starway 12.", "+450142730");
        waitingListService.saveWaitingList(waitingList1);
        waitingListService.saveWaitingList(waitingList2);
    }*/
}
