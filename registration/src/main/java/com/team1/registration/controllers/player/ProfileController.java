package com.team1.registration.controllers.player;

import com.team1.registration.models.User;
import com.team1.registration.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
@RequestMapping("/profile")
@Slf4j
@AllArgsConstructor
public class ProfileController {
    private UserService userService;

    @GetMapping
    public String options(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("balance", user.getBalance());
        return "users/options";

    }

    @GetMapping("/top-up")
    public String topUpForm() {
        return "users/top-up";
    }

    @PostMapping("/top-up")
    public String topUpAccount(@RequestParam UUID userId, @RequestParam BigDecimal amount, RedirectAttributes attr) {
        // todo: checks for amount lower than zero? |  may be checks should be in html code?
        userService.updateBalance(userService.getUserById(userId), amount);
        attr.addFlashAttribute("top_up_alert", String.format("%.2f$ successfully added!", amount));
        return "redirect:/profile";
    }

    // todo: method from another microservice
    public void makeBet(Integer userId) {

    }
}
