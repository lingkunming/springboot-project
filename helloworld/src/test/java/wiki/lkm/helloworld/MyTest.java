package wiki.lkm.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseStatus;
import wiki.lkm.helloworld.bean.Dog;
import wiki.lkm.helloworld.bean.MyLombok;
import wiki.lkm.helloworld.bean.Person;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    Person person;

    ApplicationContext context = new AnnotationConfigApplicationContext(MyLombok.class);
    @Autowired
    Dog dog;

    @Resource(name = "lombok1")
    MyLombok myLombok1;
    @Resource(name = "lombok2")
    MyLombok myLombok2;

    @Test
    public void test() {
        String string = person.toString();
        System.out.println(string);
    }

    @Test
    public void test1() {

        System.out.println(dog);
    }

    @Test
    public void test2() {

        System.out.println(myLombok1.toString());

        System.out.println(myLombok2.toString());
    }
}
