package com.example.mohsiul.githubrepisitory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface api {

    public  String BASE_URL="https://api.github.com/";

    @GET("/users/{user}/repos")
    Call<List<GitRepo>> userR(@Path("user")String user);

}
