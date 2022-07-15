package com.ll.exam;

import com.ll.exam.Util.FileUtil;
import com.ll.exam.Util.JsonParse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.ll.exam.Util.FileUtil.getMaxNumberFileName;

public class PostRepository {
    static int ids;
    ArrayList<Post> posts;
    PostService postService;
    private static PostRepository instance=new PostRepository();
    private PostRepository(){
        posts=new ArrayList<>();
        init();
        postService=new PostService();
    }
    public static PostRepository getInstance(){
        if(instance==null){
            instance=new PostRepository();
        }
        return instance;
    }

    Post save(String content,String author,String keyword){
        ids++;
        Post creatPost=new Post(ids,content,author, postService.getGifUseApi(keyword));
        File file=new File(FileUtil.getFileDirPath()+"\\"+ids+".json");
        FileUtil.fileWrite(file,creatPost);
        posts.add(creatPost);
        return creatPost;
    }
    public void deleteById(int index) {
        for (Post post : posts) {
            if (post.getId() == index) {
                posts.remove(post);
                Path path = Paths.get(FileUtil.getFilePath() + findByIndexId(getFileList(), index) + ".json");
                try {
                    Files.delete(path);
                    System.out.println(path+"삭제 성공!!");
                } catch (IOException e) {
                    System.out.println(path+"삭제 실패!!");
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
    int findByIndexId(final String[] files, final int index) {
        for (String file : files) {
            try {
                String filePath = FileUtil.getFilePath() + file;
                FileInputStream fileStream = null;
                fileStream = new FileInputStream(filePath);
                byte[] readBuffer = new byte[fileStream.available()];
                while (fileStream.read(readBuffer) != -1) {
                }
                fileStream.close();
                String result = new String(readBuffer);
                String str = JsonParse.jsonToString(result);
                String[] ars = str.split(",");
                if (Integer.parseInt(ars[0].trim()) == index) {
                    return Integer.parseInt(file.replace(".json", "").trim());
                }
                fileStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    void init() {
        String[] files=getFileList();
        System.out.println("현재 작업 경로: " + FileUtil.getFileDirPath());
        System.out.println("파일에서 자료 불러오는중...");
        if (files.length == 0) {
            System.out.println("불러올 파일이 없습니다.");
            return;
        }
        for (String file : files) {
            try {
                String filePath = FileUtil.getFileDirPath()+"\\" + file;
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
        File dir = new File(FileUtil.getFileDirPath());
        return dir.list();
    }

    public List<Post> findAll() {
        if (posts.isEmpty()) {
            System.out.println("게시글이 하나도 없습니다");
            return null ;
        }
        return posts.stream()
                .sorted(Comparator.comparing(Post::getId).reversed()).toList();
    }
}
