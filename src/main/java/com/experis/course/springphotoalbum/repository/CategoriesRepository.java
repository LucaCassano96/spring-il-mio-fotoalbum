package com.experis.course.springphotoalbum.repository;

import com.experis.course.springphotoalbum.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
