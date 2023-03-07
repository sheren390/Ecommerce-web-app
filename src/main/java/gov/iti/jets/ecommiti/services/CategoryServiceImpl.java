package gov.iti.jets.ecommiti.services;

import java.util.List;

import org.springframework.stereotype.Service;

import gov.iti.jets.ecommiti.exception.CategoryNotFoundExceptions;
import gov.iti.jets.ecommiti.models.Category;
import gov.iti.jets.ecommiti.repositories.CategoryRepository;
import lombok.Data;

@Service
@Data
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getByID(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundExceptions());
    }

}
