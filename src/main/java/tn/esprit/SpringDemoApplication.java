package tn.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.esprit.entities.Categorie;
import tn.esprit.entities.Course;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }
   // Championnat c = new Championnat();
    //Course c = new Course.builder().emplacement("test").build();
}
