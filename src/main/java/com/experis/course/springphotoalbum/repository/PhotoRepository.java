package com.experis.course.springphotoalbum.repository;

import com.experis.course.springphotoalbum.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    List<Photo> findByTitleContainingIgnoreCase(String nameKeyword);

    /*List<Photo> findByTitleContainingIgnoreCase(String s);*/
}
