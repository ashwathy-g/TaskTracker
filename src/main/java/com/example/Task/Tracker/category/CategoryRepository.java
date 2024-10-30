package com.example.Task.Tracker.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryRegModel,Integer>
 {

     Optional<CategoryRegModel> findById(Integer id);
 }
