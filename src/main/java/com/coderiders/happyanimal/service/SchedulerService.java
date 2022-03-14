package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.enums.TaskType;
import com.coderiders.happyanimal.model.Task;
import com.coderiders.happyanimal.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
@Transactional
public class SchedulerService {

    @Autowired
    private TaskRepository taskRepository;

    @Scheduled(cron = "0 0 0 * * ?")
    public void resetStateTask() {
        List<Task> result = taskRepository.findAll();
        for (var i : result) {
            if (i.getRepeatType().equals(TaskType.EVERY_DAY.getString())) {
                i.setState("in progress...");
            }
        }
    }
}
