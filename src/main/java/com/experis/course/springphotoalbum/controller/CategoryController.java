package com.experis.course.springphotoalbum.controller;
import com.experis.course.springphotoalbum.model.Categories;
import com.experis.course.springphotoalbum.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CategoryController {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping("/categories/create")
    public String showCreateCategoryForm(Model model) {
        model.addAttribute("category", new Categories());
        return "photos/createCategory";
    }

    @PostMapping("/categories/create")
    public String createCategory(@ModelAttribute Categories category, Model model) {
        if (categoriesRepository.findByName(category.getName()) == null) {
            categoriesRepository.save(category);
            model.addAttribute("created", true);
        }
        model.addAttribute("category", category);
        return "redirect:/photos";
    }
}


