package com.ll.exam;


import com.ll.exam.Util.AwsS3;
import com.ll.exam.Util.ImageApi;

import java.io.File;

public class PostService {
    private final String KEY="data.json";
    private final String PREFIX_URL="https://ssgproject.s3.ap-northeast-2.amazonaws.com/";
     String getGifUseApi(String keyword){
         return ImageApi.FindImage(keyword);
    }

    public void uploadS3(File dataJson) {
        AwsS3 awsS3=AwsS3.getInstance();
        awsS3.upload(dataJson,KEY);
        System.out.println("data.json URL : "+PREFIX_URL+KEY);
    }
}
