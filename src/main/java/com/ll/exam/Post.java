package com.ll.exam;

import lombok.Getter;

import java.time.LocalDate;

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
                "  \"id\" : " +"\""+ id + "\",\n" +
                "  \"content\" : " +"\""+ content + "\",\n" +
                "  \"author\" : " +"\""+ author + "\",\n"+
                "  \"imgUrl\" : " +"\""+ imgUrl + "\" ,\n"+
                "  \"createdTime\" : " +"\""+ createdTime + "\" \n"+
                '}';
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
