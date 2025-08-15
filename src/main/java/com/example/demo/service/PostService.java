package com.example.demo.service;

import com.example.demo.domain.Post;
import java.util.List;

public interface PostService {
    List<Post> getPosts(int page, int size);
}
