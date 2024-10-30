package com.example.Task.Tracker.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/status")
public class StatusController
{
    @Autowired
    StatusService statusService;
    @PostMapping(path = "/AddStatus")
    public ResponseEntity<?>addStatus(@RequestBody StatusRegModel statusRegModel)
    {
        return statusService.addStatus(statusRegModel);
    }

    @GetMapping(path = "/getAllStatus")
    public ResponseEntity<List<StatusRegModel>>getAllStatus()
    {
        List<StatusRegModel>getStatus=statusService.getAllStatus();
        return ResponseEntity.ok(getStatus);
    }

}
