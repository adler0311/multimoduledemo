package com.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final BlogService blogService;

    @GetMapping("/test")
    public Long test(){
        return blogService.createBlog();
    }
}