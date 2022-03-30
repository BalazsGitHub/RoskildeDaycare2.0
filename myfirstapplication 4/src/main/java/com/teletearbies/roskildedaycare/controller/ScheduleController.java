package com.teletearbies.roskildedaycare.controller;

import com.teletearbies.roskildedaycare.entity.Schedule;
import com.teletearbies.roskildedaycare.service.ChildrenNotFoundException;
import com.teletearbies.roskildedaycare.service.EmployeeService;
import com.teletearbies.roskildedaycare.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("/schedule/edit/{id}")
    public String editSchedule(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {

        try {
            Schedule schedule = scheduleService.getSchedule(id);
            model.addAttribute("schedule", schedule);
            return "schedule_form"; //Maybe not good

        } catch (ChildrenNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            model.addAttribute("pageTitle", "edit schedule (ID: " + id + ")");
            return "redirect:/scheduleList"; //Maybe not good
        }
    }

    @RequestMapping("/schedule/add")
    public String addSchedule(Model model) {
        model.addAttribute("schedule", new Schedule());
        return "schedule_form";
    }

    @PostMapping("/schedule/save")
    public String saveSchedule(Schedule schedule, RedirectAttributes redirectAttributes) {
        scheduleService.saveSchedule(schedule);
        redirectAttributes.addFlashAttribute("message", "Schedule info saved!");
        return "redirect:/scheduleList";
    }

    @RequestMapping("/schedule/delete/{id}")
    public String deleteSchedule (@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        try {
            scheduleService.deleteSchedule(id);
            redirectAttributes.addFlashAttribute("message", "Schedule was deleted!");
        } catch (ChildrenNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/scheduleList";
    }
}
