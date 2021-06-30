package oleg.work.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;

public class Student implements StudInterface {
    private int mark;
    @Value("${testProp.name1}")
    private String name;
    @Autowired
    private ResourceBundle resourceBundle;
    public Student(String name){
        this.name=name;
    }
    public Student(){}
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){return name;}

    @Override
    public void setMark(int res){
        this.mark=res;
    }
    @Override
    public void getMark() {
        System.out.println("Student "+name+ " has "+mark+" points.");
    }

}
