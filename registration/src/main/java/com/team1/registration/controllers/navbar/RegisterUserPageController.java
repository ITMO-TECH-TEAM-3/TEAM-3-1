package com.team1.registration.controllers.navbar;

import com.team1.registration.models.Role;
import com.team1.registration.models.User;
import com.team1.registration.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegisterUserPageController {

    private final UserRepository userRepository;

    @Autowired
    public RegisterUserPageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String registerUser(User user, Map<String, Object> model, RedirectAttributes attr){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if(userFromDb != null){
            model.put("message", "User exists");
            return "navbar/register";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.AUTHORIZED_USER));
        attr.addFlashAttribute("alert", "Register is successful!");
        userRepository.save(user);
        return "redirect:/";
    }
}
