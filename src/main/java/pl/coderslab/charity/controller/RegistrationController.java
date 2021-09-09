package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import pl.coderslab.charity.service.RegistrationService;
import pl.coderslab.charity.validator.RegistrationRequest;



@Controller
@RequestMapping
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String register(RegistrationRequest request) {
            registrationService.register(request);
            return "redirect:/registration?success";
    }

    @GetMapping("/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        return "accountConfirmed";
    }
}
