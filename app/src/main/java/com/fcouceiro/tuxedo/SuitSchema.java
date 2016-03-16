package com.fcouceiro.tuxedo;

/**
 * Created by franciscocouceiro on 16/03/16.
 */
public class SuitSchema {

    public SuitSchema(String name, String imageUrl){
        this.suitName = name;
        this.imageUrl = imageUrl;
    }

    public SuitSchema(String name, int imageDrawableId){
        this.suitName = name;
        this.imageDrawableId = imageDrawableId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    private String imageUrl;

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    private int imageDrawableId = -1;

    public String getSuitName() {
        return suitName;
    }

    private String suitName;

    public boolean hasImageUrl(){
        return imageDrawableId == -1;
    }
}
