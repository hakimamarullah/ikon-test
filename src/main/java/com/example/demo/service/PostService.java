package com.example.demo.service;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 10/8/2024 3:45 PM
@Last Modified 10/8/2024 3:45 PM
Version 1.0
*/

import com.example.demo.dto.PostResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PostService {
    private static List<PostResponse> posts = new ArrayList<>();
    private final RestTemplate client = new RestTemplate();
    private final ObjectMapper mapper;

    public PostService(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<PostResponse> getPosts(Map<String, String> pageable) {
        pageable = Optional.ofNullable(pageable).orElse(new HashMap<>());
        int page = Integer.parseInt(pageable.getOrDefault("page", "1"));
        int size = Integer.parseInt(pageable.getOrDefault("size", "10"));


        int startIndex = size * page - 1;

        return posts.subList(startIndex, startIndex + size);
    }

    @PostConstruct
    @SuppressWarnings("unchecked")
    public void fetchPost() {
        List<Object> response = client.getForObject("https://jsonplaceholder.typicode.com/posts", List.class);
        posts.addAll(mapper.convertValue(response, new TypeReference<List<PostResponse>>() {
        }));
    }

}
