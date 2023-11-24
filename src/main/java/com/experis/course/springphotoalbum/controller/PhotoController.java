package com.experis.course.springphotoalbum.controller;

import com.experis.course.springphotoalbum.model.Categories;
import com.experis.course.springphotoalbum.model.Photo;
import com.experis.course.springphotoalbum.repository.CategoriesRepository;
import com.experis.course.springphotoalbum.repository.PhotoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Controller
    @RequestMapping("/photos")
    public class PhotoController {


        private PhotoRepository photoRepository;
        @Autowired
        private CategoriesRepository categoriesRepository;

    @Autowired
    public PhotoController(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


     // LIST PHOTOS

        @GetMapping
        public String index(@RequestParam Optional<String> search, Model model) {
            List<Photo> photoList;
            if (search.isPresent()) {

                photoList = photoRepository.findByTitleContainingIgnoreCase( search.get() );
            } else {

                photoList = photoRepository.findAll();
            }

            model.addAttribute( "photoList", photoList );
            return "photos/photos-list";
        }


        //SHOW

        @GetMapping("/show/{id}")
        public String show(@PathVariable Integer id, Model model) {
            Optional<Photo> result = photoRepository.findById( id );
            if (result.isPresent()) {
                model.addAttribute("photo", result.get());
                return "photos/show";
            } else {
                throw new ResponseStatusException( HttpStatus.NOT_FOUND, "photo with id " + id + " not found" );
            }

        }

        //CREATE

        @GetMapping("/create")
        public String create(Model model) {
            model.addAttribute( "photo", new Photo() );
            model.addAttribute( "categoriesList", categoriesRepository.findAll() );
            return "photos/create";
        }


    //STORE

        @PostMapping("/create/store")
        public String store(@Valid @ModelAttribute("photo") Photo formPhoto, BindingResult BindingResult) {

            if (BindingResult.hasErrors()) {
                return "photos/create";
            }

            formPhoto.setCreated_at( LocalDateTime.now() );
            photoRepository.save( formPhoto );
            return "redirect:/photos/show/" + formPhoto.getId();
        }


        //EDIT

 /*   public List<Category> getAll() {
        return categoryRepository.findByOrderByName();
        model.addAttribute("categoryList", categoryService.getAll());
    }*/


        @GetMapping("/edit/{id}")
        public String edit(@PathVariable Integer id, Model model) {
            Optional<Photo> result = photoRepository.findById( id );

            if (result.isPresent()) {
                model.addAttribute( "photo", result.get() );
                model.addAttribute("categoriesList", categoriesRepository.findAll());
                return "photos/edit";
            } else {
                throw new ResponseStatusException( HttpStatus.NOT_FOUND, "photo with id " + id + " not found" );
            }

        }


    //UPDATE
    @PostMapping("/edit/update/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categoriesList", categoriesRepository.findAll());
            return "photos/edit";
        }

        Photo photoToEdit = photoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        photoToEdit.setTitle(formPhoto.getTitle());
        photoToEdit.setDescription(formPhoto.getDescription());
        photoToEdit.setPhoto_url(formPhoto.getPhoto_url());
        photoToEdit.setVisible(formPhoto.getVisible());

        List<Categories> selectedCategories = formPhoto.getCategories();
        photoToEdit.setCategories(selectedCategories);
        Photo savedPhoto = photoRepository.save(photoToEdit);

        return "redirect:/photos";
    }

            @PostMapping("/delete/{id}")
            public String delete(@PathVariable Integer id) {

            Photo pizzaToDelete = photoRepository.findById( id ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
            photoRepository.deleteById( id );
            return "redirect:/photos";
        }
    }


