package gov.iti.jets.ecommiti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.iti.jets.ecommiti.models.Category;


public interface CategoryRepository extends JpaRepository<Category,Integer>{
    
}
