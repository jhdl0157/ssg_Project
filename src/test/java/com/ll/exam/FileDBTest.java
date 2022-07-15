package com.ll.exam;

import com.ll.exam.Util.FileUtil;
import org.apache.commons.validator.routines.UrlValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
public class FileDBTest {
    @BeforeEach
    void beforeEach(){
        FileUtil.deleteDir(FileUtil.getFileDirPath());
        FileUtil.mkdir(FileUtil.getFileDirPath());
    }
    @Test
    void initTest(){
        PostRepository postRepository=PostRepository.getInstance();
        postRepository.init();
        String[] lists=postRepository.getFileList();
        assertEquals(0,lists.length);
    }
    @Test
    void 키워드로_gif링크찾기() throws IOException {
        PostService postService=new PostService();
        String url=postService.getGifUseApi("happy");
        assertTrue(UrlValidator.getInstance().isValid(url));
    }

    @Test
    void 파일_만들어보기(){
        PostRepository postRepository=PostRepository.getInstance();
        Post post=new Post(1,"test","name","happy");
    }
    @Test
    void getMaxNumberFileName() {
        PostRepository postRepository=PostRepository.getInstance();
        String[] lists=postRepository.getFileList();
        assertEquals(0,FileUtil.getMaxNumberFileName(lists));
    }

}
