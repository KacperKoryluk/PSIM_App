package com.app.psim.psim_mobile;

import java.util.List;

/**
 * Created by Xemur on 01.05.2018.
 */

public class Post {

    public Post(String title, List<String> tags, String description, String attachment, String author) {
        Title = title;
        Tags = tags;
        Description = description;
        Attachment = attachment;
        Author = author;
    }

    public String Title;
    public List<String> Tags;
    public String Description;
    public String Attachment;
    public String Author;
}
