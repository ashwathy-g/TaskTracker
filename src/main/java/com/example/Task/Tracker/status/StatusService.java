package com.example.Task.Tracker.status;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

    public ResponseEntity<?> addStatus(StatusRegModel statusRegModel)
    {
        StatusRegModel statusRegModel1=statusRepository.save(statusRegModel);
        return new ResponseEntity<>(statusRegModel1, HttpStatus.OK);
    }

    public List<StatusRegModel> getAllStatus()
    {
        return statusRepository.findAll();
    }
}
