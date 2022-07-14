package com.ll.exam;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Post {
    int id;
    String content;
    String author;
    String imgUrl;
    LocalDate createdTime;
    public Post(int id,String content,String author,String imgUrl){
        this.id=id;
        this.content=content;
        this.author=author;
        this.imgUrl=imgUrl;
        this.createdTime=LocalDate.now();
    }

}
