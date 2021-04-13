package com.rukon.controller;

import com.rukon.businessl.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class WebController {

    // == constructor ==
    private final MessageService messageService;

    @Autowired
    public WebController(MessageService messageService) {
         this.messageService = messageService;
    }

    private List<String> names = new ArrayList<>();
    // http://localhost:8080/TodoList/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "<h1>hello</h1>";
    }

    // http://localhost:8080/TodoList/welcome
    @GetMapping("welcome")
    public String welcome(@RequestParam(value = "lname", defaultValue = "Khan", required = false) String lname, Model model){
        model.addAttribute("helloMessage", messageService.getHelloMessage("Rukon"));
        model.addAttribute("lastName", lname);
        names.add("rukon");
        names.add("Ripon");
        names.add("Rajon");
        model.addAttribute("names", names);
        log.info("model = {}", model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return messageService.getWelcomeMessage();
    }
}
