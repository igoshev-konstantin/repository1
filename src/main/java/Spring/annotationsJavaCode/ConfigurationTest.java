package Spring.annotationsJavaCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan("Spring.annotationsJavaCode")
public class ConfigurationTest {

    public enum Names {Ivan, Alex, Adndrew}

    ;

    enum Professions {Programmer, Teacher}

    ;

    public static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationTest.class);

    public static void main(String[] args) {
        Worker w = context.getBean("worker", Worker.class);
        System.out.println("Worker: " + w.person.name + " Profession: " + w.pType);
    }

}

@Component
class Person {
    ConfigurationTest.Names name;
    ProfessionType professionType;

    public Person() {
        this.name = ConfigurationTest.Names.values()[(int) (Math.random() * 3)];
        //this.professionType = getProfessionType();
    }

    @Bean("professionType")
    public ProfessionType getProfessionType() {
        return new ProfessionType();
    }

}

class ProfessionType {
    ConfigurationTest.Professions profession;

    public ProfessionType() {
        this.profession = ConfigurationTest.Professions.values()[(int) (Math.random() * 2)];
    }
}

@Component
class Worker {
    Person person;
    ProfessionType pType;

    @Autowired
    public Worker(Person person, ProfessionType pType) {
        this.person = person;
        this.pType = pType;
    }
}