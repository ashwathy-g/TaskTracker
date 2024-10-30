package com.example.Task.Tracker.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/cat")
public class CategoryController
{
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;


    @PostMapping(path = "/Cat_Add")
    public ResponseEntity<?>registerCatAdd(@RequestBody CategoryRegModel categoryRegModel )
    {
        return categoryService.registerCatAdd(categoryRegModel);
    }
    @GetMapping(path = "/getAllCategory")
    public ResponseEntity<List<CategoryRegModel>>getAllCategory()


    {
        List<CategoryRegModel> getCategories=categoryService.getAllCategory();
        return ResponseEntity.ok(getCategories);
    }


}
