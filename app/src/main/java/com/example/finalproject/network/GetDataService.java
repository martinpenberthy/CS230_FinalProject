package com.example.finalproject.network;

import com.example.finalproject.model.Comment;
import com.example.finalproject.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/photos")
    //@GET("/woof.json")
    Call<List<RetroPhoto>> getAllPhotos();

   /* @GET("/comments")
    Call<List<Comment>> getAllComments();*/
}
