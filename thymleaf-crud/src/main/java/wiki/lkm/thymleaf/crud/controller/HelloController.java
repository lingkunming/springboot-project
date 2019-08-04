package wiki.lkm.thymleaf.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wiki.lkm.thymleaf.crud.bean.User;
import wiki.lkm.thymleaf.crud.service.HelloService;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class HelloController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private HelloService helloService;

    @PostMapping("/login")
    public String hello(User user, HttpSession session, Model model) {
        logger.info("登陆方法--> 账号：" + user.getUsername() + "密码：" + user.getPassword());
        if (user.getUsername().equals("ling") && user.getPassword().equals("ling123")) {
            session.setAttribute("user", user);
            model.addAttribute("user",user);
            return "main";
        } else {
            return "login";
        }
    }

    @RequestMapping("/")
    public String goLogin() {
        return "login";
    }

    @RequestMapping(value = {"/index"})
    public String index(Model model) {
        model.addAttribute("hello", "hello world");
        model.addAttribute("list", Arrays.asList(1, 2, 3));
        helloService.hello();
        return "dashboard";
    }

    @ResponseBody
    @PutMapping("/testPut")
    public String testPut(@RequestParam String hello) {
        System.out.println(hello);
        return "hello hello";
    }
}
