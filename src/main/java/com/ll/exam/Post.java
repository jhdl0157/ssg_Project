package com.ll.exam;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ll.exam.ImageApi.FindImage;

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
    }
    @Override
    public String toString() {
        return "{\n" +
                " \"id\" : " +"\""+ id + "\",\n" +
                " \"content\" : " +"\""+ content + "\",\n" +
                " \"author\" : " +"\""+ author + "\",\n"+
                " \"imgUrl\" : " +"\""+ imgUrl + "\" ,\n"+
                " \"createdTime\" : " +"\""+ createdTime + "\" \n"+
                '}';
    }

    public String toJson() {
        return """
                {
                    "id": %d,
                    "content": "%s",
                    "author": "%s",
                    "imgUrl": "%s",
                    "createdTime": "%s"
                }
                """
                .stripIndent()
                .formatted(id, content, author,imgUrl,createdTime.toString())
                .trim();
    }
    public void registDate (){
        this.createdTime=LocalDate.now();
    }
    public void setCreatedTime(String date){
        this.createdTime= LocalDate.parse(date);
    }
    public void setCreatedTime(LocalDate date){
        this.createdTime= date;
    }


}
