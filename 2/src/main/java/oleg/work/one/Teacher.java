package oleg.work.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Teacher {
    @Value("${testProp.name3}")
    private String name;
    private Test test;
    @Autowired
    private ResourceBundle resourceBundle;

    public Teacher(Test test) {
        this.test = test;
    }

    public void Result()
    {

        try {
            test.startTest();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(name+ " took the test:");

        test.getMark();
    }
}
