package gov.iti.jets.ecommiti.services;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import gov.iti.jets.ecommiti.exception.ProductNotFoundException;
import gov.iti.jets.ecommiti.mappers.ProductMapper;
import gov.iti.jets.ecommiti.models.Product;
import gov.iti.jets.ecommiti.dtos.request.ProductDto;
import gov.iti.jets.ecommiti.repositories.ProductRepository;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }

    public List<ProductDto> getAllproducts() {
        List <Product> products =productRepository.findAll();
        return ProductMapper.productMapper.mapToProductDto(products);   
     }

     public List<ProductDto> getproducts() {
    
        List <Product> products =productRepository.findAll();
        Predicate<Product> isDeleted= product -> product.getIsDeleted()==false;
        products=products.stream().filter(isDeleted).collect(Collectors.toList());
        return ProductMapper.productMapper.mapToProductDto(products);   
     }

    public ProductDto getProductById(int id) 
    {
        Product product =productRepository.findById(id).orElseThrow(()->new ProductNotFoundException());
        if(product.getIsDeleted()==true)
        {
           throw new ProductNotFoundException();
        }
        return ProductMapper.productMapper.mapToProductDto(product); 
    }

    public Product createProuduct(ProductDto productDto)
    {
        Product product = ProductMapper.productMapper.mapToProduct(productDto);
        productRepository.save(product);
        return product;
    }
    public ProductDto deleteProuduct(int id)
    {
        Product product =productRepository.findById(id).orElseThrow(()->new ProductNotFoundException());
        product.setIsDeleted(Boolean.TRUE);
        return ProductMapper.productMapper.mapToProductDto(productRepository.save(product)); 
       }

       public void remove(int id)
       {
        productRepository.deleteById(id);
       }

    public ProductDto updateProuduct(int id,ProductDto productDto)
    {
        productDto.setId(id);
        return ProductMapper.productMapper.mapToProductDto(productRepository.save(ProductMapper.productMapper.mapToProduct(productDto)));
    }

    public List<ProductDto> getProductByName(String name)
     {
        List<Product> products =productRepository.findByName(name);
       Predicate<Product> isDeleted = product -> product.getIsDeleted()==false;
       products=products.stream().filter(isDeleted).collect(Collectors.toList());
       return ProductMapper.productMapper.mapToProductDto(products);   
     }
  

    
}
