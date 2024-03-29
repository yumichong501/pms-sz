package pms.sz.task.pmssz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class PmsSzApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmsSzApplication.class, args);
    }

}
