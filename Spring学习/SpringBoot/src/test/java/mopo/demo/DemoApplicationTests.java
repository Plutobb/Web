package mopo.demo;

import mopo.demo.Pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    Student student;

    @Test
    void contextLoads() {
        System.out.println(student);
    }

}
