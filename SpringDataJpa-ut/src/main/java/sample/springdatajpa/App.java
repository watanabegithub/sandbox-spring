package sample.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class App {

    @Autowired
    private SampleService sampleService;

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return sampleService.dataAccess();
    }

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
