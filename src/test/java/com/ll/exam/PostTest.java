package com.ll.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    @Test
    void Post_Test(){
        Post post=new Post(1,"test","name","naver.com");
        assertEquals(1,post.id);
        assertEquals("test",post.content);
        assertEquals("name",post.author);
        assertEquals("naver.com",post.imgUrl);
    }

}