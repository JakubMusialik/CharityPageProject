package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;

import pl.coderslab.charity.repository.CategoryRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }
}
