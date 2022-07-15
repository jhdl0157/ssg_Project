package com.ll.exam;

import java.util.List;
import java.util.Scanner;

public class PostController {

    private PostRepository postRepository;
    Scanner sc;
    public PostController(Scanner sc){
        this.sc=sc;
        this.postRepository=PostRepository.getInstance();
    }

    public void write(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        System.out.print("명언에 어울리는 키워드 입력(한/영 모두 가능) : ");
        String keyword = sc.nextLine().trim();
        Post post=postRepository.save(content,author,keyword);
        System.out.println(post.toString());
    }

    public void remove(Rq rq) {
        postRepository.deleteById(rq.getIntParam("id",0));
    }

    public void modify(Rq rq) {
        postRepository.updateById(rq.getIntParam("id",0));
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언 / 등록일");
        System.out.println("----------------------");
        List<Post> posts=postRepository.findAll();
        posts.forEach(x -> System.out.println(x.getId() + " /  " + x.getAuthor() + "  /  " + x.getContent()+ "  /  " + x.getCreatedTime()));
    }

    public void buildJson() {
        postRepository.makeJson();
    }
}
