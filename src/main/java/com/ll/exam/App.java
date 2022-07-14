package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    App(Scanner sc){
        this.sc=sc;
    }
    void run(){
        System.out.println("== 명언 SSG ==");
        PostController postController=new PostController(sc);
        while(true){
            System.out.print("명령)");
            String cmd=sc.nextLine().trim();


        }

    }

}
