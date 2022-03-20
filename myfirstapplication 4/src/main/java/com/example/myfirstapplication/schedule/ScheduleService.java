package com.example.myfirstapplication.schedule;

import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public void saveEmployee(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public Schedule findById(int id) {
        return scheduleRepository.findById(id).get();
    }

    public List<Schedule> getAllUsers() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

}
