package com.sboo.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ValidatedPhoneController {
    @GetMapping("/validatedPhone")
    public String loadFormPage(Model m) {
        m.addAttribute("validatedPhone", new ValidatedPhone());
        return "phoneHome";
    }

    @PostMapping("/validatedPhone")
    public String submitForm(@Valid ValidatedPhone validatedPhone,
                             BindingResult bindingResult, Model m) {
        if(bindingResult.hasErrors()) {
            return "phoneHome";
        }
        m.addAttribute("message", "Successfully saved phone: " + validatedPhone.toString());
        return "phoneHome";
    }
}
