package com.example.kodakanatsumi.words;

import android.graphics.drawable.StateListDrawable;
import android.net.NetworkInfo;
import android.util.StateSet;

/**
 * Created by kodakanatsumi on 2017/05/17.
 */

public class Card {
    public int imageId;
    public String title;
    public String content;
    public int likeNum = 0;

    public String meaning;
    public boolean isChecked = false;

    public Card(int imageId, String title, String content, String meaning) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
        this.meaning = meaning;
    }
}
