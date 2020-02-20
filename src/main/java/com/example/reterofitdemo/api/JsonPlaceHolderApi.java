package com.example.reterofitdemo.api;

import com.example.reterofitdemo.models.PostModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")   // THIS ANNOTATION IS USED TO TELL RETROFIT WHAT TO DO LIKE GET DATA OR POST DATA AND "posts" is the directory in  "  https://jsonplaceholder.typicode.com/posts "
    Call<List<PostModel>> getPosts();
}
