package gov.iti.jets.ecommiti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.iti.jets.ecommiti.models.Category;
import gov.iti.jets.ecommiti.services.CategoryServiceImpl;
import lombok.Data;

@RestController
@Data
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/categories")
    List<Category> getAll() {
        return categoryServiceImpl.getAll();
    }
}
