import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void test1(){
        //使用Spring创建对象

        //1.指定Spring配置文件名称
        String config = "applicationContext.xml";

        //2.创建表示Spring的容器对象,ApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);//ClassPahXmlApplicationContext:表示从根目录获取文件

        //3.调用bean从Spring容器中获取对象
        //这里getBean直接获取的是Object,需要转换类型
        SpringTest springTest = (SpringTest) ac.getBean("test");

        //4.接下来就可以使用对象
        springTest.test();
    }
    @Test
    public void t2(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        student st = (student) ac.getBean("student");
        System.out.println("student = "+st);
    }
}
