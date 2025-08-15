package com.example.demo.client;

import com.example.demo.domain.Post;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PostClientImpl implements PostClient {

    private final RestTemplate restTemplate;
    private final String postsApi;

    public PostClientImpl(RestTemplateBuilder builder,
                          @Value("${external.posts.api:https://jsonplaceholder.typicode.com/posts}") String postsApi) {
        this.restTemplate = builder.build();
        this.postsApi = postsApi;
    }

    @Override
    public List<Post> fetchPosts() {
        Post[] response = restTemplate.getForObject(postsApi, Post[].class);
        return Arrays.asList(response);
    }
}
