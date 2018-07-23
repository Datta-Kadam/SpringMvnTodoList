package academy.learnprogramming.controller;

import academy.learnprogramming.service.DemoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {
    //==fields===
    private final DemoServiceImpl demoService;

    //==Constructor==
    @Autowired
    public DemoController(DemoServiceImpl demoService) {
        this.demoService= demoService;
    }

    //==Request methods===
    //http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //http://localhost:8080/todo-list/welcome
    //http://localhost:8080/todo-list/welcome?user=Datta
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age,Model model){
      model.addAttribute("helloMessage",demoService.getHelloMessage(user));
        model.addAttribute("age",age);
      log.info("mode = {}",model);
        //prefix+name+suffix
        //WEB-INF/view/welcome.jsp
      return "welcome";
    }

    //==Model Attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }

 /*   @ModelAttribute("helloMessage")
    public String helloMessage(){
        log.info("helloMessage() called");
        return demoService.getHelloMessage("Datta");
    }*/


}
