package com.example.Task.Tracker.category;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public ResponseEntity<?> registerCatAdd(CategoryRegModel categoryRegModel)
    {
        CategoryRegModel categoryRegModel1=categoryRepository.save(categoryRegModel);
        return new ResponseEntity<>(categoryRegModel1,HttpStatus.OK);
    }

    public List<CategoryRegModel> getAllCategory()
    {
        return categoryRepository.findAll();
    }


}
