package gov.iti.jets.ecommiti.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.iti.jets.ecommiti.dtos.response.CategoryResponseDto;
import gov.iti.jets.ecommiti.mappers.CategoryMapper;
import gov.iti.jets.ecommiti.models.Category;
import gov.iti.jets.ecommiti.services.CategoryServiceImpl;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api/test")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")

public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;
    private final CategoryMapper categoryMapper;

    @GetMapping("/categories")
    List<CategoryResponseDto> getAll() {
        return categoryMapper.INSTANCE.map(categoryServiceImpl.getAll());
    }
}
