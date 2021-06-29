package oleg.work.one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
              "applicationContext.xml");
        //StudInterface studInterface = context.getBean("studOleg",StudInterface.class);
        //Test test= new Test(studInterface);
        Test test = context.getBean("testOleg", Test.class);
        try {
            test.startTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Starting test!!!\n");
        test.getMark();
        context.close();
    }

}
