package gov.iti.jets.ecommiti.repositories;

import gov.iti.jets.ecommiti.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
