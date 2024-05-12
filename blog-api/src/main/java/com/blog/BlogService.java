package com.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    public final ConfirmRepository confirmRepository;

    public Long createBlog() {
        Confirm confirm = confirmRepository.saveAndFlush(Confirm.builder().id(1L).description("test222").build());
        return confirm.getId();
    }
}
