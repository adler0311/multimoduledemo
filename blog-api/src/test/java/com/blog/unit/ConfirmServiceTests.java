package com.blog.unit;

import com.blog.BlogService;
import com.blog.Confirm;
import com.blog.ConfirmRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConfirmServiceTests {
    @Mock
    private ConfirmRepository confirmRepository;

    @InjectMocks
    private BlogService blogService;

    @Test
    public void testReserveBook() {
        Confirm confirm = new Confirm();
        confirm.setId(1L);
        confirm.setDescription("Spring Boot");
        when(confirmRepository.saveAndFlush(any(Confirm.class))).thenReturn(confirm);

        Long reservedBook = blogService.createBlog();
        assertEquals(1L, (long) reservedBook);
    }
}
