package com.example.demo.client;

import com.example.demo.domain.Post;
import java.util.List;

public interface PostClient {
    List<Post> fetchPosts();
}
