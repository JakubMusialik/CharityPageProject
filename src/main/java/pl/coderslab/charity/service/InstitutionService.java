package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepo;


import java.util.List;

@Service
@AllArgsConstructor
public class InstitutionService {
    private final InstitutionRepo institutionRepo;


    public List<Institution> findAllInstitutions() {
        return institutionRepo.findAll();
    }

    public List<Institution> findAll(PageRequest pageRequest) {
        Page<Institution> institutionsPage = institutionRepo.findAll(pageRequest);
        return institutionsPage.getContent();
    }
}

