package me.jamieburns.springboot2;

import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.jamieburns.springboot2.model.Employee;
import me.jamieburns.springboot2.model.EmployeeRepository;

@Configuration
public class LoadDatabase {

    private static final Logger log = Logger.getLogger( LoadDatabase.class.getName() );

    @Bean
    CommandLineRunner initDatabase( EmployeeRepository repository ) {

        return args -> {
            log.info( "Preloading " + repository.save( new Employee( "Bilbo Baggins", "burglar" ) ) );
            log.info( "Preloading " + repository.save( new Employee( "Frodo Baggins", "thief" ) ) );
        };
    }

}
