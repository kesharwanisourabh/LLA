package com.example.android.lla;

import android.content.Intent;
import java.nio.charset.MalformedInputException;

public class word {

    private String mOriginalLang;
    private String mMiwokLang;
    private int mImageResId=-1;
    private int mAudioResourceId;

    public word(String Original,String Marathi,int ImageId,int audio){
        mOriginalLang=Original;
        mMiwokLang=Marathi;
        mImageResId=ImageId;
        mAudioResourceId=audio;
    }

    public word(String Original,String Marathi,int audio){
        mOriginalLang=Original;
        mMiwokLang=Marathi;
        mAudioResourceId=audio;
    }
    public String getDefaultTrans(){
        return mOriginalLang;
    }

    public String getMiwokTrans(){

        return mMiwokLang;
    }

    public int getmImageResId(){

        return mImageResId;
    }

    public int getmAudioResourceId(){

        return mAudioResourceId;
    }

    Boolean hasImage(){
        return getmImageResId()!= -1;
    }
}
