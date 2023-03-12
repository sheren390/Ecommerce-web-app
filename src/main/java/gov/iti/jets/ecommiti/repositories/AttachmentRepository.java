package gov.iti.jets.ecommiti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.iti.jets.ecommiti.models.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}
