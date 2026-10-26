package com.mjamal.portfolio.web;

import com.mjamal.portfolio.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Year;

@Controller
public class HomeController {

    private final ProfileService profileService;

    public HomeController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("profile", profileService.getProfile());
        model.addAttribute("year", Year.now().getValue());
        return "index";
    }
}
