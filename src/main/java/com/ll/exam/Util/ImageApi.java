package com.ll.exam.Util;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;
import com.ll.exam.ApiKey;

public class ImageApi {
    private static  final String API_KEY= ApiKey.API_KEY.getKey();
    public static String FindImage(String keyword)  {
        //TODO API키를 발급받아서 넣어주세요!!
        Giphy giphy=new Giphy(API_KEY);
        try {
            SearchFeed feed = giphy.search(keyword, 1, (int) (Math.random()*10));
            return feed.getDataList().get(0).getImages().getOriginal().getUrl();
        } catch (GiphyException e){
            e.printStackTrace();
        }
        return "";
    }
}
