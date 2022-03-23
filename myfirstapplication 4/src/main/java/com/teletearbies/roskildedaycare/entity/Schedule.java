package com.teletearbies.roskildedaycare.entity;

import javax.persistence.*;


@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schedule_id;

    @OneToOne(mappedBy = "employeeSchedule")
    private Employee employee;

    @Column(length = 45, name = "monday")
    private String monday;

    @Column(length = 45, name = "tuesday")
    private String tuesday;

    @Column(length = 45, name = "wednesday")
    private String wednesday;

    @Column(length = 45, name = "thursday")
    private String thursday;

    @Column(length = 45, name = "friday")
    private String friday;


    public Schedule() {
    }

    public Schedule(String monday, String tuesday, String wednesday, String thursday, String friday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }

    public Integer getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Integer schedule_id) {
        this.schedule_id = schedule_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }
}
