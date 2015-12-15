package sample.springbootweb;

import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
