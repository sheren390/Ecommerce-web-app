package gov.iti.jets.ecommiti.services;

import java.util.List;

import org.springframework.stereotype.Service;

import gov.iti.jets.ecommiti.dtos.response.CategoryResponseDto;
import gov.iti.jets.ecommiti.exception.CategoryEmptyNameException;
import gov.iti.jets.ecommiti.exception.CategoryNotFoundExceptions;
import gov.iti.jets.ecommiti.mappers.CategoryMapper;
import gov.iti.jets.ecommiti.models.Category;
import gov.iti.jets.ecommiti.models.ResponseViewModel;
import gov.iti.jets.ecommiti.repositories.CategoryRepository;
import lombok.Data;

@Service
@Data
public class CategoryServiceImpl {

    private final CategoryRepository categoryRepository;

    public ResponseViewModel<List<CategoryResponseDto>> getAll() {
        ResponseViewModel<List<CategoryResponseDto>> responseViewModel = new ResponseViewModel<>();
        responseViewModel.setData(CategoryMapper.INSTANCE.map(categoryRepository.findAll()));
        return responseViewModel;
    }

    public ResponseViewModel<CategoryResponseDto> getByID(Integer id) {
        ResponseViewModel<CategoryResponseDto> responseViewModel = new ResponseViewModel<>();
        responseViewModel.setData(CategoryMapper.INSTANCE
                .map(categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundExceptions())));
        return responseViewModel;
    }

    public ResponseViewModel<CategoryResponseDto> getByName(String name) {
        ResponseViewModel<CategoryResponseDto> responseViewModel = new ResponseViewModel<>();
        responseViewModel.setData(CategoryMapper.INSTANCE
                .map(categoryRepository.findByName(name).orElseThrow(() -> new CategoryNotFoundExceptions())));
        return responseViewModel;
    }

    public ResponseViewModel<CategoryResponseDto> create(Category category) {
        Category c;
        ResponseViewModel<CategoryResponseDto> responseViewModel = new ResponseViewModel<>();
        try {
            c = categoryRepository.save(category);
        } catch (Exception e) {
            throw new CategoryEmptyNameException();
        }
        responseViewModel.setData(CategoryMapper.INSTANCE.map(c));
        return responseViewModel;
    }

    public ResponseViewModel<CategoryResponseDto> update(Integer id, Category object) {
        ResponseViewModel<CategoryResponseDto> responseViewModel = new ResponseViewModel<>();
        responseViewModel.setData(CategoryMapper.INSTANCE.map(categoryRepository.save(object)));
        return responseViewModel;
    }

    public ResponseViewModel<Integer> delete(Integer id) {
        categoryRepository.softDeleteCategoryById(id);
        categoryRepository.deleteById(id);
        ResponseViewModel<Integer> responseViewModel = new ResponseViewModel<>();
        responseViewModel.setMessage("Category deleted");
        return responseViewModel;
    }

}
