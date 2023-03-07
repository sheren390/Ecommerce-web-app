package gov.iti.jets.ecommiti.repositories;

import gov.iti.jets.ecommiti.models.ERole;
import gov.iti.jets.ecommiti.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles,Integer> {
    Optional<Roles> findByName(ERole name);
}
