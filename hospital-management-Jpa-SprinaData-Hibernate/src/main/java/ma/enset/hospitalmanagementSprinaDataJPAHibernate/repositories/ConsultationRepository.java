package ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories;

import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Consultation;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
