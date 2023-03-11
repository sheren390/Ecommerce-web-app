package gov.iti.jets.ecommiti.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.iti.jets.ecommiti.dtos.request.CategoryRequestDto;
import gov.iti.jets.ecommiti.dtos.response.CategoryResponseDto;
import gov.iti.jets.ecommiti.mappers.CategoryMapper;
import gov.iti.jets.ecommiti.models.Category;
import gov.iti.jets.ecommiti.models.ResponseViewModel;
import gov.iti.jets.ecommiti.services.CategoryServiceImpl;
import jakarta.websocket.server.PathParam;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Data
@RequestMapping("/api/test/categories")
// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")

public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    @GetMapping
    ResponseViewModel<List<CategoryResponseDto>> getAll() {
        return categoryServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    ResponseViewModel<CategoryResponseDto> getByID(@PathVariable int id) {
        return categoryServiceImpl.getByID(id);
    }

    @GetMapping("/name")
    ResponseViewModel<CategoryResponseDto> getByName(@RequestParam String name) {
        return categoryServiceImpl.getByName(name);
    }

    @PostMapping
    public ResponseViewModel<CategoryResponseDto> add(@RequestBody Category category) {
        return categoryServiceImpl.create(category);
    }

    @PutMapping("/{id}")
    public ResponseViewModel<CategoryResponseDto> update(@PathVariable int id, @RequestBody Category category) {
        category.setId(id);
        return categoryServiceImpl.update(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseViewModel<Integer> delete(@PathVariable int id) {
        return categoryServiceImpl.delete(id);
    }
}
