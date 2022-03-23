package com.teletearbies.roskildedaycare.controller;

import com.teletearbies.roskildedaycare.entity.Schedule;
import com.teletearbies.roskildedaycare.service.EmployeeService;
import com.teletearbies.roskildedaycare.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/scheduleList")
    public String manageEmployeeSchedules(Model model){
        List<Schedule> scheduleList = scheduleService.getAllSchedules();
        model.addAttribute("scheduleList", scheduleList);

        return "manage_schedules";
    }

    @RequestMapping("/createWorkSchedule")
    public String manageEmployeeSchedule(Model model) {
        model.addAttribute("allEmployees", employeeService.getAllEmployees());

        return "manage_schedules";
    }

    @RequestMapping("/editSchedule/{id}")
    public String getEditschdulePage(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "edit_schedules";
    }

    /*@RequestMapping("/addScheduleShiftFor/{id}")
    public String addScheduleShiftFor(@PathVariable("id") int id,
                                      @RequestParam("shiftStart") String shiftStart,
                                      @RequestParam("shiftEnd") String shiftEnd,
                                      Model model){
        Employee employee = employeeService.findById(id);

        String ISO_8601_24H_FULL_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ISO_8601_24H_FULL_FORMAT);

        LocalDateTime dateFrom = LocalDateTime.parse(shiftStart, formatter);
        LocalDateTime dateTo = LocalDateTime.parse(shiftEnd, formatter);

       Schedule schedule = new Schedule(dateFrom, dateTo);

        employee.setEmployeeSchedule(schedule);
        schedule.setEmployee(employee);

        scheduleService.saveSchedule(schedule);


        return "redirect:/createWorkSchedules";
    }
*/

}
