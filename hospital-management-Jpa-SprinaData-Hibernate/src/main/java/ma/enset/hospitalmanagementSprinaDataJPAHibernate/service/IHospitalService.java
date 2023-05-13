package ma.enset.hospitalmanagementSprinaDataJPAHibernate.service;

import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Consultation;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Medecin;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Patient;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
