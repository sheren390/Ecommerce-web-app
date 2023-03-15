package gov.iti.jets.ecommiti.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.iti.jets.ecommiti.models.Category;
import jakarta.transaction.Transactional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT * FROM category WHERE name LIKE %:name% AND id != 1", nativeQuery = true)
    Optional<List<Category>> findByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("update Product p set p.category.id = 1 where p.category.id = :id")
    int softDeleteCategoryById(@Param("id") Integer id);

}
