package ma.enset.hospitalmanagementSprinaDataJPAHibernate;

import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Consultation;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Medecin;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.Patient;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.entites.RendezVous;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.enumerations.StatusRDV;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories.ConsultationRepository;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories.MedecinRepository;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories.PatientRepository;
import ma.enset.hospitalmanagementSprinaDataJPAHibernate.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalManagementJpaSprinaDataHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementJpaSprinaDataHibernateApplication.class, args);
	}

	@Bean //execute au demarrage, return Object , composant Spring == @Compenet
	CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){ //injection des dependances
		return args -> {
			patientRepository.save(new Patient(null,"Patient1",new Date(),false,null));

			Stream.of("Patient2","Patient3","Patient4","Patient5").forEach(name -> {
				Patient patient = new Patient();
				patient.setName(name);
				patient.setMalade(true);
				patient.setDateNaissance(new Date());
				patientRepository.save(patient);
			});

			Stream.of("Medecin2","Medecin3","Medecin4","Medecin5").forEach(name -> {
				Medecin medecin = new Medecin();
				medecin.setName(name);
				medecin.setSpeciality(Math.random()>0.5?"Cardio":"Dentiste");
				medecin.setMail(name+"@gmail.com");
				medecinRepository.save(medecin);
			});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByName("Patient2");

			Medecin medecin = medecinRepository.findByName("Medecin2");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			rendezVousRepository.save(rendezVous);

			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de consultation");
			consultationRepository.save(consultation);
		};
	}

}
