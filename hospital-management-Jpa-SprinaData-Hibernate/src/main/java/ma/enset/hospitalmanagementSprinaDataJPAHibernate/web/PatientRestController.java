package ma.enset.hospitalmanagementSprinaDataJPAHibernate.web;

import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Patient;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public List<Patient> findPatient(){
        return patientRepository.findAll();
    }
}
