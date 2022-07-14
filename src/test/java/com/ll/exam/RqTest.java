package com.ll.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RqTest {
    @Test
    void Rq_getPath(){
        Rq rq = new Rq("삭제?id=2");
        String path = rq.getPath();
        assertEquals("삭제", path);
    }

    @Test
    void Rq_getIntParam(){
        Rq rq = new Rq("삭제?id=2");
        int intParam=rq.getIntParam("id",0);
        assertEquals(2,intParam);
    }

    @Test
    void Rq_여러개값_파싱(){
        Rq rq = new Rq("삭제?id=2&keyword=123");
        int intParam=rq.getIntParam("id",0);
        int intParam2=rq.getIntParam("keyword",0);
        int intParam3=rq.getIntParam("sdasd",0);
        assertEquals(2,intParam);
        assertEquals(123,intParam2);
        assertEquals(0,intParam3);
    }

}