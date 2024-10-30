package com.example.Task.Tracker.task;

import com.example.Task.Tracker.category.CategoryRegModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/task")
public class TaskController
{
    @Autowired
    TaskService taskService;
    @PostMapping(path = "/taskAdd")
    public ResponseEntity<?>taskAdd(@RequestBody TaskRegModel taskRegModel)
    {
        return taskService.taskAdd(taskRegModel);
    }

    @GetMapping(path = "/getAllTask")
    public ResponseEntity<List<TaskRegModel>>getAllTasks()
    {
        List<TaskRegModel>getTasks=taskService.getAllTask();
        return ResponseEntity.ok(getTasks);
    }
    @GetMapping(path = "/getTaskByCatId/{catId}")
    public ResponseEntity<List<TaskRegModel>>getCategoryById(@PathVariable Integer catId)
    {
        return taskService.getTaskByCategoryId(catId);
    }
    @GetMapping(path = "/getTaskByCatId/{catId}/getTaskByStatusId/{statusId}")
    public ResponseEntity<List<TaskRegModel>>getCategoryAndStatusBYId(@PathVariable Integer catId,@PathVariable Integer statusId)
    {
        return taskService.getTaskByCategoryAndStatusId(catId,statusId);
    }
    @PutMapping(path = "/updateStatus/{Id}")
    public ResponseEntity<?>updateStatus(@PathVariable Integer Id, @RequestParam  Integer statusId)
    {
        return taskService.updateStatus(Id,statusId);

    }
  @DeleteMapping(path = "/{id}")
    public ResponseEntity<?>deleteTask(@PathVariable Integer id)
  {
      return taskService.deleteById(id);
  }



}
