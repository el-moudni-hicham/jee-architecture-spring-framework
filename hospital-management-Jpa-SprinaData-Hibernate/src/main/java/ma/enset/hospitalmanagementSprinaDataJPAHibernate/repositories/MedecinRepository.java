package ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories;

import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Medecin;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByName(String name);
}
