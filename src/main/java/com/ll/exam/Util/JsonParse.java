package com.ll.exam.Util;

public class JsonParse {
    static public String jsonToString(final String result) {
        String str = result.replace("{", "").replace("}", "")
                .replace("\"id\" : ", "").replace("\"content\" : ", "")
                .replace("\"author\" : ", "").replace("\"imgUrl\" : ", "").replace("\"createdTime\" : ", "").replaceAll("\"", "");
        return str;
    }
}
