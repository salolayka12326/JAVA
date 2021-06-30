package oleg.work.one;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
@PropertySource("testProperties.properties")
public class SpringConfig {
    @Bean
    public MessageSource messageSource()
    {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("src/main/resources/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
    @Bean
    public ResourceBundle resourceBundle(){ return ResourceBundle.getBundle("bundle", new Locale("ru","RU")); }
    @Bean
    public Student student()
    {
        return new Student();
    }
    @Bean
    public Studentka studentka()
    {
        return new Studentka();
    }
    @Bean
    public Test test()
    {
        return new Test(student(),studentka());
    }
    @Bean
    public Teacher teacher()
    {
        return new Teacher(test());
    }
}
