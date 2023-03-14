package gov.iti.jets.ecommiti.services;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import gov.iti.jets.ecommiti.models.Category;
import org.springframework.stereotype.Service;

import gov.iti.jets.ecommiti.exception.ProductNotFoundException;
import gov.iti.jets.ecommiti.mappers.ProductMapper;
import gov.iti.jets.ecommiti.models.Product;
import gov.iti.jets.ecommiti.models.ResponseViewModel;
import gov.iti.jets.ecommiti.dtos.request.ProductDto;
import gov.iti.jets.ecommiti.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseViewModel getAllproducts() {
        ResponseViewModel responseViewModel = new ResponseViewModel();
        List<Product> products = productRepository.findAll();
        responseViewModel.setData(ProductMapper.productMapper.mapToProductDto(products));
        return responseViewModel;
    }

    public ResponseViewModel getProductsByCategory(int id){
        ResponseViewModel responseViewModel= new ResponseViewModel();
        List<Product> products = productRepository.findProductsByCategory(id);
        responseViewModel.setData(ProductMapper.productMapper.mapToProductDto(products));
        return responseViewModel;
    }

    public ResponseViewModel getproducts() {
        ResponseViewModel responseViewModel = new ResponseViewModel();
        List<Product> products = productRepository.findAll();
        Predicate<Product> isDeleted = product -> product.getIsDeleted() == false;
        products = products.stream().filter(isDeleted).collect(Collectors.toList());
        responseViewModel.setData(ProductMapper.productMapper.mapToProductDto(products));
        return responseViewModel;
    }

    public ResponseViewModel getProductById(int id) {
        ResponseViewModel responseViewModel = new ResponseViewModel();

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
        if (product.getIsDeleted() == true) {
            throw new ProductNotFoundException();
        }
        responseViewModel.setData(ProductMapper.productMapper.mapToProductDto(product));
        return responseViewModel;
    }

    public ResponseViewModel createProuduct(ProductDto productDto) {
        ResponseViewModel responseViewModel = new ResponseViewModel();

        Product product = ProductMapper.productMapper.mapToProduct(productDto);
        productRepository.save(product);
        responseViewModel.setData(product);
        return responseViewModel;
    }

    public ResponseViewModel deleteProuduct(int id) {
        ResponseViewModel responseViewModel = new ResponseViewModel();

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
        product.setIsDeleted(Boolean.TRUE);
        responseViewModel.setData(ProductMapper.productMapper.mapToProductDto(productRepository.save(product)));
        return responseViewModel;
    }

    public void remove(int id) {
        productRepository.deleteById(id);
    }

    public ResponseViewModel updateProuduct(int id, ProductDto productDto) {
        ResponseViewModel responseViewModel = new ResponseViewModel();

        productDto.setId(id);
        responseViewModel.setData(ProductMapper.productMapper
        .mapToProductDto(productRepository.save(ProductMapper.productMapper.mapToProduct(productDto))));
        return responseViewModel;
    }

    public ResponseViewModel getProductByName(String name) {
        ResponseViewModel responseViewModel = new ResponseViewModel();

        List<Product> products = productRepository.findByName(name);
        Predicate<Product> isDeleted = product -> product.getIsDeleted() == false;
        products = products.stream().filter(isDeleted).collect(Collectors.toList());
        responseViewModel.setData(ProductMapper.productMapper.mapToProductDto(products));
        return responseViewModel;
    }

}
