package com.experis.course.springphotoalbum.controller;

import com.experis.course.springphotoalbum.model.Photo;
import com.experis.course.springphotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
    @RequestMapping("/photos")
    public class PhotoController {


        private PhotoRepository photoRepository;

    @Autowired
    public PhotoController(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }



        @GetMapping
        public String index(Model model) {
            List<Photo> photoList = photoRepository.findAll();
            model.addAttribute("photoList", photoList);
            return "photos/photos-list";
        }
    }
