package com.fakenews.db;

import com.fakenews.News.News;

import java.util.ArrayList;

public class NewsDatabase {

    static ArrayList<News> allNews = new ArrayList<>();

    static {
        allNews.add(new News(1L, "Elon Musk buys the UFC", "After buying twitter," +
                "Elon Musk says, f**k it, I need a fighting league", "Matthew Matthews", "Sports"));
        allNews.add(new News(2L, "Joe Biden forgot that he is the president", "After landing in Switzerland" +
                "Joe Biden was confused why the military was greeting him 'I thought we were going to ski' said Joe to Jill Biden",
                "John Jones", "Politics"));
        allNews.add(new News(3L, "Johny Depp after the trouble with Amber Heard decided to become Gay",
                "That's much easier than to deal with women, besides I look gay anyway", "Clip Clipperson", "Entertainment"));
    }

    public static ArrayList<News> getAllNews(){
        return allNews;
    }
    }
