package ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories;

import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Patient;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
