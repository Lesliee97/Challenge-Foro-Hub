package com.leslierodriguez.foroalura.controller;

import com.leslierodriguez.foroalura.service.ITopicService;
import com.leslierodriguez.foroalura.service.dto.TopicRequestDTO;
import com.leslierodriguez.foroalura.service.dto.TopicResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private ITopicService topicService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> list() {
        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON).
                body(this.topicService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON).
                body(this.topicService.findById((long)id));
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody TopicRequestDTO topic) {
        TopicResponseDTO response = this.topicService.save(topic);
        return ResponseEntity.status(HttpStatus.CREATED).
                contentType(MediaType.APPLICATION_JSON).
                body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody TopicRequestDTO topic, @PathVariable Long id) {
        TopicResponseDTO response = this.topicService.update(topic, id);
        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON).
                body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        this.topicService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
