package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationSpringVerAnnotations {
    public static void main(String[] args) {
        ApplicationContext springContext = new AnnotationConfigApplicationContext("dao","metier"); // Scan this packages
        IMetier metier = springContext.getBean(IMetier.class);
        System.out.println("Result = " + metier.calcul());
    }
}
