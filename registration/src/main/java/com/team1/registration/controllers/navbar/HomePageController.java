package com.team1.registration.controllers.navbar;

import com.team1.registration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
@RequestMapping
public class HomePageController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home() {
        return "navbar/home";
    }

    @GetMapping("/register")
    public String register() {
        try{
            userService.getCurrentUser();
        }
        catch (NoSuchElementException e){
            return "navbar/register";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest req, Map<String, Object> model) {
        try{
            userService.getCurrentUser();
        }
        catch (NoSuchElementException e){
            var y = req.getParameter("error");
            model.put("error", y);
            return "navbar/login";
        }
        return "redirect:/";
    }

    @GetMapping("tournaments")
    public String tournaments() {
        // todo: fix name
        return "tournaments";
    }
}
