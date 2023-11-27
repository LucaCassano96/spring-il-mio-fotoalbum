package com.experis.course.springphotoalbum.repository;

import com.experis.course.springphotoalbum.model.Categories;
import com.experis.course.springphotoalbum.model.Message;
import org.jboss.logging.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
