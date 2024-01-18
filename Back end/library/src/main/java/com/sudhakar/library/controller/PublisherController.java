package com.sudhakar.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhakar.library.entity.Publisher;
import com.sudhakar.library.service.PublisherService;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @PostMapping("/create-publisher")
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        ResponseEntity<Publisher> responseEntity = publisherService.createPublisher(publisher);
        return responseEntity;
    }

    @PutMapping("/update-publisher/{publisherId}")
    public ResponseEntity<Publisher> updatePublisherByPublisherId(@PathVariable String publisherId, @RequestBody Publisher updatedPublisher) {
        ResponseEntity<Publisher> responseEntity = publisherService.updatePublisherByPublisherId(publisherId, updatedPublisher);
        return responseEntity;
    }

    @DeleteMapping("/delete-publisher/{publisherId}")
    public ResponseEntity<Void> deletePublisherByPublisherId(@PathVariable String publisherId) {
        ResponseEntity<Void> responseEntity = publisherService.deletePublisherByPublisherId(publisherId);
        return responseEntity;
    }
}

