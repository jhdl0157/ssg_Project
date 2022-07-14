package com.ll.exam;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;

public class ImageApi {
    private static  final String API_KEY=ApiKey.API_KEY.getKey();
    static String FindImage(String keyword)  {
        Giphy giphy=new Giphy(API_KEY);
        int randomInt= (int) (Math.random()*10);
        System.out.println(randomInt);
        try {
            SearchFeed feed = giphy.search(keyword, 1, randomInt);
            return feed.getDataList().get(0).getImages().getOriginal().getUrl();
        } catch (GiphyException e){
            e.printStackTrace();
        }
        return "";
    }
}
