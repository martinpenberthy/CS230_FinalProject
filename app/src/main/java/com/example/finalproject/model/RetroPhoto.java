package com.example.finalproject.model;
import android.util.Log;

import com.google.gson.annotations.SerializedName;


public class RetroPhoto {
    @SerializedName("albumId")
    private Integer albumId;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public RetroPhoto(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }


   /* @SerializedName("fileSizeBytes")
    private Integer fileSizeBytes;

    @SerializedName("url")
    private String url;

    public RetroPhoto(Integer fileSizeBytes, String url) {
        this.fileSizeBytes = fileSizeBytes;
        this.url = url;


        Log.d("Debug", "RetroPhoto Constructor");
    }


    public Integer getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(Integer fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

*/


    /*@SerializedName("success")
    private Boolean success;
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("width")
    private Integer width;
    @SerializedName("height")
    private Integer height;
    @SerializedName("box_count")
    private Integer box_count;
    @SerializedName("captions")
    private Integer captions;


    public RetroPhoto(Boolean success, String id, String name, String url, Integer width,
                      Integer height, Integer box_count, Integer captions) {
        this.success = success;
        this.id = id;
        this.name = name;
        this.url = url;
        this.width = width;
        this.height = height;
        this.box_count = box_count;
        this.captions = captions;

        Log.d("Debug", "RetroPhoto Constructor");
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getBox_count() {
        return box_count;
    }

    public void setBox_count(Integer box_count) {
        this.box_count = box_count;
    }

    public Integer getCaptions() {
        return captions;
    }

    public void setCaptions(Integer captions) {
        this.captions = captions;
    }*/



}
