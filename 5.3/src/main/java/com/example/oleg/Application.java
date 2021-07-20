package com.example.oleg;
//
import com.example.oleg.dao.DAO;
import com.example.oleg.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {


    private static DAO<Course> dao;

    public Application(DAO<Course> dao){
        this.dao = dao;

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("\n Create course -----------------------\n");
        Course springVue = new Course("trololo", "mega trololo","kuadro super trololo");
        dao.create(springVue);

        System.out.println("\n One Course -----------------------\n");
        Optional<Course> firstOne = dao.get(1);
        System.out.println(firstOne.get());

        springVue.setDescription("TTTTTTTTTRRRRRRRRRRROLLLLOLOLO");
        dao.update(springVue,3);

        dao.delete(2);


        System.out.println("\n ALL Courses -----------------------\n");
        List<Course> courses = dao.list();
        courses.forEach(System.out::println);
    }

}
