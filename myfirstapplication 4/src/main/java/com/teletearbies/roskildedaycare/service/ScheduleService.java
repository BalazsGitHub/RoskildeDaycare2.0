package com.teletearbies.roskildedaycare.service;

import com.teletearbies.roskildedaycare.entity.Children;
import com.teletearbies.roskildedaycare.entity.Schedule;
import com.teletearbies.roskildedaycare.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public void saveSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public Schedule findById(int id) {
        return scheduleRepository.findById(id).get();
    }

    public List<Schedule> getAllSchedules() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    public Schedule getSchedule(Integer id) throws ChildrenNotFoundException {
        Optional<Schedule> result = scheduleRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ChildrenNotFoundException("Could not find any Schedule with id: " + id);
    }

    public void deleteSchedule(Integer id) throws ChildrenNotFoundException {
        Long count = scheduleRepository.countById(id);
        if (count == null || count == 0)
        {
            throw new ChildrenNotFoundException("Could not find schedule with id "  + id);
        }
        scheduleRepository.deleteById(id);
    }

}
