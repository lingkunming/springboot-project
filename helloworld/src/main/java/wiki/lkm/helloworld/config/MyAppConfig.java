package wiki.lkm.helloworld.config;

import lombok.Lombok;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wiki.lkm.helloworld.bean.Dog;
import wiki.lkm.helloworld.bean.MyLombok;

@Configuration
public class MyAppConfig {
    @Bean
    public Dog dog(){
        Dog dog =new Dog();
        dog.setAge(2);
        dog.setName("coco");
        return dog;
    }

    @Bean(name = "lombok1")
    public MyLombok myLombok(){
        return new MyLombok(1,"name");
    }
    @Bean(name = "lombok2")
    public MyLombok myLombok2(){
       MyLombok myLombok= new MyLombok();
       myLombok.setAge(12);
       myLombok.setName("hello");
       return myLombok;
    }
}
