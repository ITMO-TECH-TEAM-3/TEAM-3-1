package com.team1.registration.controllers.navbar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping
public class HomePageController {
    @GetMapping("/")
    public String home() {
        return "navbar/home";
    }

    @GetMapping("/register")
    public String register(){
        return "navbar/register";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest req, Map<String, Object> model){
        var y = req.getParameter("error");
        model.put("error", y);
        return "navbar/login";
    }

    @GetMapping("tournaments")
    public String tournaments(){ // todo: fix name
        return "tournaments";
    }
}
