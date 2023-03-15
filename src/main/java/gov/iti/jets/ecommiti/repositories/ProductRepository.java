package gov.iti.jets.ecommiti.repositories;

import gov.iti.jets.ecommiti.models.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE name LIKE %:name%", nativeQuery = true)
    List<Product> findByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("select p from Product p where p.category.id = :id")

    int softDeleteCategoryById(@Param("id") Integer id);

    List<Product> findProductsByCategory(@Param("id") Integer id);
}
