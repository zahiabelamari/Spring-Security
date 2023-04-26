package ma.emsi.springsecurity;
import ma.emsi.springsecurity.entities.Patient;
import ma.emsi.springsecurity.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "Kawtar", new Date(), false,12));
            patientRepository.save(new Patient(null, "Ibtissam", new Date(), true,20));
            patientRepository.save(new Patient(null, "Reda", new Date(), false,50));
            patientRepository.save(new Patient(null, "Amine", new Date(), true,90));
            patientRepository.findAll().forEach(
                    p->{
                        System.out.println(p.getNom());
                    }
            );
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}