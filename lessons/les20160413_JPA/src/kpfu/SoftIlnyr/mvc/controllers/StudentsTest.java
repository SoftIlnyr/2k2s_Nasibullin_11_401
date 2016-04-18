package kpfu.SoftIlnyr.mvc.controllers;

import kpfu.SoftIlnyr.mvc.entities.StudentsEntity;
import kpfu.SoftIlnyr.mvc.repositories.StudentsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 13.04.2016.
 */
public class StudentsTest {
    private static JpaRepository repository;
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        repository = context.getBean(StudentsRepository.class);

        List<StudentsEntity> students = repository.findAll();
        for (StudentsEntity student : students) {
            System.out.println(student.getName());
        }

    }
}
