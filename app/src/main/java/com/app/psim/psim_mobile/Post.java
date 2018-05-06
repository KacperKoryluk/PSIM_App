package com.app.psim.psim_mobile;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xemur on 01.05.2018.
 */

public class Post implements Parcelable {

    public Post(String title, List<String> tags, String description, String attachment, String author) {
        Title = title;
        Tags = tags;
        Description = description;
        Attachment = attachment;
        Author = author;
    }
    private Post(Parcel data)
    {
        Title = data.readString();
        Description = data.readString();
        Attachment = data.readString();
        Author = data.readString();
        Tags = new ArrayList<String>();
        int tagsSize = data.readInt();
        for (int i = 0; i < tagsSize; ++i)
            Tags.add(data.readString());
    }

    public String Title;
    public List<String> Tags;
    public String Description;
    public String Attachment;
    public String Author;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Title);
        dest.writeString(Description);
        dest.writeString(Attachment);
        dest.writeString(Author);
        dest.writeInt(Tags.size());
        for (int i = 0; i < Tags.size(); ++i)
            dest.writeString(Tags.get(i));
    }

    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>(){
        public Post createFromParcel(Parcel data)
        {
            return new Post(data);
        }
        public Post[] newArray(int size)
        {
            return new Post[size];
        }
    };
}
