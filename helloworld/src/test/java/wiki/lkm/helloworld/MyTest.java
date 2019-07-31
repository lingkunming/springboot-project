package wiki.lkm.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiki.lkm.helloworld.bean.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    Person person;

    @Test
    public void test() {
        String string = person.toString();
        System.out.println(string);
    }
}
