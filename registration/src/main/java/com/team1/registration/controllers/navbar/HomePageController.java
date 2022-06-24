package com.team1.registration.controllers.navbar;

import com.team1.registration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
//        try{
//            userService.getCurrentUser();
//        }
//        catch (UsernameNotFoundException e){
//            return "navbar/register";
//        }
        return "navbar/register";
//        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest req, Map<String, Object> model) {
//        try{
//            userService.getCurrentUser();
//        }
//        catch (UsernameNotFoundException e){
//            var y = req.getParameter("error");
//            model.put("error", y);
//            return "navbar/login";
//        }
//        return "redirect:/";
            var y = req.getParameter("error");
            model.put("error", y);
            return "navbar/login";
    }

    @GetMapping("tournaments")
    public String tournaments() {
        // todo: fix name
        return "tournaments";
    }
}
