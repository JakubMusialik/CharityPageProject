package pl.coderslab.charity.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/form")
@AllArgsConstructor
public class DonationController {

    DonationService donationService;
    CategoryService categoryService;
    InstitutionService institutionService;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "donationForm";
    }

    @PostMapping
    public String makeDonation(@ModelAttribute("donation")@Valid Donation donation, BindingResult result) {
        if (result.hasErrors()) {
            return "donationForm";
        } else {
            donationService.registerDonation(donation);
            return "formConfirmation";
        }
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryService.findAllCategories();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutionList() {
        return institutionService.findAllInstitutions();
    }


}
