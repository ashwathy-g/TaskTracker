package com.example.Task.Tracker.task;

import com.example.Task.Tracker.category.CategoryRegModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public ResponseEntity<?> taskAdd(TaskRegModel taskRegModel) {
        TaskRegModel taskRegModel1 = new TaskRegModel();
        taskRegModel1.setCatId(taskRegModel.getCatId());
        taskRegModel1.setStatusId(taskRegModel.getStatusId());
        taskRegModel1.setDescription(taskRegModel.getDescription());
        taskRegModel1.setCreatedAt(LocalDateTime.now());
        return new ResponseEntity<>(taskRepository.save(taskRegModel1), HttpStatus.OK);
    }

    public List<TaskRegModel> getAllTask() {
        return taskRepository.findAll();
    }


    public ResponseEntity<List<TaskRegModel>> getTaskByCategoryId(Integer catId) {
        List<TaskRegModel> taskRegModelList = taskRepository.findBycatId(catId);
        if (!taskRegModelList.isEmpty()) {
            return new ResponseEntity<>(taskRegModelList, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<TaskRegModel>> getTaskByCategoryAndStatusId(Integer catId, Integer statusId) {
        List<TaskRegModel> taskRegModelList = taskRepository.findByCatIdAndStatusId(catId, statusId);


        if (!taskRegModelList.isEmpty()) {
            return new ResponseEntity<>(taskRegModelList, HttpStatus.OK);

        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> updateStatus(Integer Id, Integer statusId) {
        Optional<TaskRegModel> taskRegModel = taskRepository.findById(Id);
        if (!taskRegModel.isEmpty()) {
            TaskRegModel taskRegModel1 = taskRegModel.get();
            taskRegModel1.setStatusId(taskRegModel1.getStatusId());
            taskRegModel1.setUpdatedAt(LocalDateTime.now());
            taskRepository.save(taskRegModel1);
            return new ResponseEntity<>(taskRegModel1, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Object(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> deleteById(Integer id) {

        Optional<TaskRegModel> taskRegModelOptional = taskRepository.findById(id);
        if (taskRegModelOptional.isPresent()) {
            TaskRegModel taskRegModel1 = taskRegModelOptional.get();
            taskRepository.delete(taskRegModel1);
            return new ResponseEntity<>("Task Deleted Successfully",HttpStatus.OK);

        }

        return new ResponseEntity<>(taskRegModelOptional, HttpStatus.NOT_FOUND);
    }
}




