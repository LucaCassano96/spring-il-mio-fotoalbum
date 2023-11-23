package com.experis.course.springphotoalbum.controller;

import com.experis.course.springphotoalbum.model.Photo;
import com.experis.course.springphotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Controller
    @RequestMapping("/photos")
    public class PhotoController {


        private PhotoRepository photoRepository;

    @Autowired
    public PhotoController(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


     // LIST PHOTOS

        @GetMapping
        public String index(Model model) {
            List<Photo> photoList = photoRepository.findAll();
            model.addAttribute("photoList", photoList);
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
    }


