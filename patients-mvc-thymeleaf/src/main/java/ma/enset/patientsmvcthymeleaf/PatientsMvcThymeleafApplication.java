package ma.enset.patientsmvcthymeleaf;

import ma.enset.patientsmvcthymeleaf.entites.Patient;
import ma.enset.patientsmvcthymeleaf.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientsMvcThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcThymeleafApplication.class, args);
    }

    /*@Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            Stream.of("PATIENT1","PATIENT2","PATIENT3","PATIENT4").forEach(p -> {
                Patient patient = Patient.builder()
                        .name(p)
                        .birthDate(new Date())
                        .malade(Math.random() > 0.5 ? false : true)
                        .score(new Random().nextInt(40))
                        .build();
                patientRepository.save(patient);
            });
            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient.getName());
            });

        };
    }*/
}
