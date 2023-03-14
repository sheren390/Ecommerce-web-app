package gov.iti.jets.ecommiti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.iti.jets.ecommiti.models.Product;
import gov.iti.jets.ecommiti.models.ResponseViewModel;
import gov.iti.jets.ecommiti.dtos.request.ProductDto;
import gov.iti.jets.ecommiti.services.ProductService;

@RestController
@RequestMapping("api/test/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseViewModel getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("category/{id}")
    public ResponseViewModel getProductByCategory(@PathVariable int id) {
        return productService.getProductsByCategory(id);
    }

    @GetMapping("/name/{name}")
    public ResponseViewModel getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/all")
    public ResponseViewModel getAllProducts() {
        return productService.getAllproducts();
    }

    @GetMapping
    public ResponseViewModel getProducts() {
        return productService.getproducts();
    }

    @PostMapping
    public ResponseViewModel createProuduct(@RequestBody ProductDto productDto) {
        return productService.createProuduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProuduct(@PathVariable int id) {
        productService.deleteProuduct(id);
    }

    @DeleteMapping("/remove/{id}")
    public void removeProuduct(@PathVariable int id) {
        productService.remove(id);
    }

    @PutMapping("/{id}")
    public ResponseViewModel updateProuduct(@PathVariable int id, @RequestBody ProductDto productDto) {
        return productService.updateProuduct(id, productDto);
    }
}
