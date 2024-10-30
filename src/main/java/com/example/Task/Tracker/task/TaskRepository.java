package com.example.Task.Tracker.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskRegModel,Integer>
{


    List<TaskRegModel> findBycatId(Integer categoryId);

    List<TaskRegModel> findByCatIdAndStatusId(Integer catId, Integer statusId);


}
