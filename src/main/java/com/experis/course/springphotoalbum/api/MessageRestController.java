package com.experis.course.springphotoalbum.api;

import com.experis.course.springphotoalbum.model.Message;
import com.experis.course.springphotoalbum.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class MessageRestController {

    private MessageRepository messageRepository;

    @Autowired
    public MessageRestController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return ResponseEntity.ok()
                .body("Message sent successfully!");
    }
}
