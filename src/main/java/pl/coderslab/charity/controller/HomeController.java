package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/")
public class HomeController {

    private final DonationService donationService;
    private final InstitutionService institutionService ;

    @GetMapping
    public String homeAction() {
        return "index";
    }

    /*ILOŚĆ WORKÓW*/
    @ModelAttribute("givenDonations")
    public long showDonationBags() {
        return donationService.getAllDonations();
    }

    /*ILOŚĆ DARÓW(FINAL)*/
    @ModelAttribute("donationsForInstitutions")
    public long showDonations() {
        return donationService.getCountOfDonationsQuantity();
    }


    @ModelAttribute("institutions")
    public List<Institution> showInstitutions() {
        return institutionService.findAll(PageRequest.of(0,4));
    }
}