package com.example.demo.service;

import com.example.demo.client.PostClient;
import com.example.demo.domain.Post;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostClient postClient;

    public PostServiceImpl(PostClient postClient) {
        this.postClient = postClient;
    }

    @Override
    public List<Post> getPosts(int page, int size) {
        if (page < 1 || size < 1) {
            throw new IllegalArgumentException("Page and size must be positive");
        }
        List<Post> allPosts = postClient.fetchPosts();
        int fromIndex = Math.min((page - 1) * size, allPosts.size());
        if (fromIndex >= allPosts.size()) {
            return Collections.emptyList();
        }
        int toIndex = Math.min(fromIndex + size, allPosts.size());
        return allPosts.subList(fromIndex, toIndex);
    }
}
