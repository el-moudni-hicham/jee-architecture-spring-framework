package ma.enset.hospitalmanagementSprinaDataJPAHibernate.service;

import lombok.AllArgsConstructor;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Consultation;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Medecin;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Patient;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.RendezVous;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories.ConsultationRepository;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories.MedecinRepository;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories.PatientRepository;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
