package mopo.pojo;

import mopo.pojo.Annotation.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void Test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) context.getBean("Hello");
        System.out.println(hello);
    }

    @Test
    public void Test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("SetContext");
        System.out.println(student);
    }
    @Test
    public void Test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Annotation.xml");
        People people = context.getBean("People", People.class);
        people.getCat().shout();
    }

}
