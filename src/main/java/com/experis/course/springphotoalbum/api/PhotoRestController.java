package com.experis.course.springphotoalbum.api;

import com.experis.course.springphotoalbum.model.Photo;
import com.experis.course.springphotoalbum.repository.PhotoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


    @RestController
    @RequestMapping("/api/v1/photos")
    @CrossOrigin
    public class PhotoRestController {

        private final PhotoRepository photoRepository;


        public PhotoRestController(PhotoRepository photoRepository) {
            this.photoRepository = photoRepository;
        }

        @GetMapping
        public ResponseEntity<List<Photo>> getPhotos(@RequestParam Optional<String> search) {
            List<Photo> photoList;
            if (search.isPresent()) {
                photoList = photoRepository.findByTitleContainingIgnoreCase(search.get());
            } else {
                photoList = photoRepository.findAll();
            }

            return new ResponseEntity<>(photoList, HttpStatus.OK);
        }
    }

