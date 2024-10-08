package com.example.demo.controller;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 10/8/2024 3:45 PM
@Last Modified 10/8/2024 3:45 PM
Version 1.0
*/

import com.example.demo.dto.PostResponse;
import com.example.demo.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public ResponseEntity<List<PostResponse>> getPosts(@RequestParam() Map<String, String> pageable) {
        log.info("{}", pageable);
        return ResponseEntity.ok(postService.getPosts(pageable));
    }
}
