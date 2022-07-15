package com.ll.exam;

import com.ll.exam.Util.Rq;

import java.util.Scanner;

public class App {
    private Scanner sc;
    App(Scanner sc){
        this.sc=sc;
    }
    void run(){
        System.out.println("== 명언 SSG ==");
        PostController postController=new PostController(sc);
        outer:
        while(true){
            System.out.print("명령)");
            String cmd=sc.nextLine().trim();
            Rq rq=new Rq(cmd);
            switch (rq.getPath()){
                case "등록":
                    postController.write(rq);
                    break;
                case "삭제":
                    postController.remove(rq);
                    break;
                case "수정":
                    postController.modify(rq);
                    break;
                case "목록":
                    postController.list(rq);
                    break;
                case "빌드":
                    postController.buildJson();
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}
