package com.ll.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    @Test
    void Post_Test(){
        Post post=new Post(1,"test","name","cry");
        System.out.println(post.createdTime);
        System.out.println(post.imgUrl);
        assertEquals(1,post.id);
        assertEquals("test",post.content);
        assertEquals("name",post.author);
        assertTrue(post.imgUrl.contains("https://"));
    }

}