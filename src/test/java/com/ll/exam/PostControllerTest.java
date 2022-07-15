package com.ll.exam;

import com.ll.exam.Util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostControllerTest {
    PostRepository postRepository=PostRepository.getInstance();
    @BeforeEach
    void beforeEach(){
        FileUtil.deleteDir(FileUtil.getFileDirPath());
        FileUtil.mkdir(FileUtil.getFileDirPath());
    }
    @Test
    void write() {
       Post post=postRepository.save("test","name","happy");
       String[] files=postRepository.getFileList();
       assertEquals(1,files.length);
    }

    @Test
    void remove() {
    }

    @Test
    void modify() {
    }

    @Test
    void list() {
    }

    @Test
    void buildJson() {
    }
}