package com.team1.registration.controllers.navbar;

import com.team1.registration.controllers.ControllerUtils;
import com.team1.registration.models.User;
import com.team1.registration.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Controller
@AllArgsConstructor
public class RegisterUserPageController {
    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(
            @Valid User user,
            BindingResult bindingResult,
            Model model, RedirectAttributes attr,
            HttpServletRequest httpServletRequest
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("user", user);
            return "navbar/register";
        } else {
            if (!userService.registerUser(user, httpServletRequest)) {
                model.addAttribute("message", "User exists");
                return "navbar/register";
            }
        }

        attr.addFlashAttribute("alert", "Register is successful!");
        return "redirect:/";
    }
}
