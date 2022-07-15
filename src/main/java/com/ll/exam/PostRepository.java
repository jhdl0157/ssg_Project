package com.ll.exam;

import com.ll.exam.Util.FileUtil;
import com.ll.exam.Util.JsonParse;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static com.ll.exam.Util.FileUtil.getMaxNumberFileName;

public class PostRepository {
    static int ids;
    ArrayList<Post> posts;
    private static PostRepository instance=new PostRepository();
    private PostRepository(){
        posts=new ArrayList<>();
        init();
    }
    public static PostRepository getInstance(){
        if(instance==null){
            instance=new PostRepository();
        }
        return instance;
    }

    Post save(String content,String author,String keyword){
        ids++;
        String imgUrl=ImageApi.FindImage(keyword);
        Post creatPost=new Post(ids,content,author,imgUrl);
        posts.add(creatPost);
        File file=new File(FileUtil.getFilePath()+"\\"+ids+".json");
        FileUtil.fileWrite(file,creatPost);
        return creatPost;
    }

    void init() {
        String[] files=getFileList();
        System.out.println("현재 작업 경로: " + FileUtil.getFilePath());
        System.out.println("파일에서 자료 불러오는중...");
        if (files.length == 0) {
            System.out.println("불러올 파일이 없습니다.");
            return;
        }
        for (String file : files) {
            try {
                String filePath = FileUtil.getFilePath()+"\\" + file;
                FileInputStream fileStream = null;
                fileStream = new FileInputStream(filePath);
                byte[] readBuffer = new byte[fileStream.available()];
                while (fileStream.read(readBuffer) != -1) {
                }
                String result = new String(readBuffer);
                String str = JsonParse.jsonToString(result);
                String[] ars = str.split(",");
                int index = Integer.parseInt(ars[0].trim());
                Post post = new Post(index, ars[1].trim(), ars[2].trim(),ars[3].trim());
                this.posts.add(post);
                fileStream.close();
                System.out.println("파일 : "+file+" 불러오기 완료!!");
                ids = getMaxNumberFileName(getFileList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    String[] getFileList() {
        File dir = new File(FileUtil.getFilePath());
        return dir.list();
    }


}
