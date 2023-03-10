package gov.iti.jets.ecommiti.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.iti.jets.ecommiti.models.Images;

public interface ImagesRepository extends JpaRepository<Images,Integer>{
    Optional<Images> findByName(String fileName);

}
