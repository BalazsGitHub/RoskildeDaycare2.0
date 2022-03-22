package com.teletearbies.roskildedaycare.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToOne(mappedBy = "employeeSchedule")
    private Employee employee;

    private String shiftName;
    private LocalDateTime time;

    public Schedule(){}

    public Schedule(Integer id, Employee employee, String shiftName, LocalDateTime time) {
        this.id = id;
        this.employee = employee;
        this.shiftName = shiftName;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer schedule_id) {
        this.id = schedule_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
