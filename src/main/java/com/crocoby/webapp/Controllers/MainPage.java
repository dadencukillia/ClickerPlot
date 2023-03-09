package com.crocoby.webapp.Controllers;

import com.crocoby.webapp.Statics.Static;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class MainPage {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("clicks", Static.clicks);
        return "main/index";
    }

    @GetMapping("/click")
    public RedirectView pop() {
        Static.clicks++;
        return new RedirectView("/");
    }

    @GetMapping("/click_n_get")
    public @ResponseBody String click_n_get() {
        Static.clicks++;
        return String.valueOf(Static.clicks);
    }

    @GetMapping("/get")
    public @ResponseBody String get() {
        return String.valueOf(Static.clicks);
    }
}
