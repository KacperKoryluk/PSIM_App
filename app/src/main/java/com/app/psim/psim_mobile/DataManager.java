package com.app.psim.psim_mobile;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager singleton = null;
    public static DataManager Singleton() {
        if(singleton == null) singleton = new DataManager();
        return singleton;
    }
    private List<Post> storedPosts;

    public void AddPost(Post post)
    {
        //TODO: Some fancy post sending
        storedPosts.add(post);
    }
    public List<Post> GetPosts()
    {
        storedPosts = UpdateStoredPosts();
        return new ArrayList<Post>(storedPosts);
    }
    public List<Post> GetPosts(List<String> keywords)
    {
        List<Post> list = GetPosts();
        int iter = 0;
        while (iter < list.size())
        {
            boolean keywordFound = false;
            for (int i = 0; i < keywords.size(); ++i)
            {
                if(SearchKeyword(list.get(iter), keywords.get(i)) == true)
                {
                    keywordFound = true;
                    break;
                }
            }
            if(keywordFound == true)
                ++iter;
            else
                list.remove(iter);
        }
        return list;
    }

    private boolean SearchKeyword(Post post, String keyword)
    {
        return (post.Description != null && post.Description.contains(keyword)) ||
               (post.Tags != null && post.Tags.contains(keyword))||
               (post.Title != null && post.Title.contains(keyword));
    }
    private List<Post> UpdateStoredPosts()
    {
        //TODO: Some fancy google drive data downloader
        ArrayList<Post> list = new ArrayList<Post>();
        list.add(new Post("Kappa", null, "I can read sumthing", "", "Xemur"));
        list.add(new Post("Hekken Mekken", null, "Das is a nice description", "", "Xemur"));
        list.add(new Post("Przeciez to sie nie godzi by tak bylo", null, "This text must be very long so i can check if the maximum height property is doing it's work. Please be patient. Somebody once told me that you have a boyfriend that looks like a girlfriend that i had in february of lat year. Please be patient. Somebody once told me that you have a boyfriend that looks like a girlfriend that i had in february of lat year.", "", "Xemur"));
        return list;
    }
}
