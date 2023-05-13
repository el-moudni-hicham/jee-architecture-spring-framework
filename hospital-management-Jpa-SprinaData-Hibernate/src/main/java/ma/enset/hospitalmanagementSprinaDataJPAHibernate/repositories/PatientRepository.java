package ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories;

import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

}
