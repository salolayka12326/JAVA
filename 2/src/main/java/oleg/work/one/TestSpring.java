package oleg.work.one;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;


public class TestSpring {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );
        System.out.println("Starting test!!!\n");

        Teacher teacher = context.getBean("teacher",Teacher.class);
        teacher.Result();

        ResourceBundle bundleEn = ResourceBundle.getBundle("bundle", new Locale("en","EN"));
        ResourceBundle bundleRu = ResourceBundle.getBundle("bundle", new Locale("ru","RU"));
        System.out.println(bundleRu.getString("testProp.name3"));
        System.out.println(bundleEn.getString("testProp.name3"));
        System.out.println(context.getBean("resourceBundle", ResourceBundle.class).getString("testProp.name3"));
    }

}
