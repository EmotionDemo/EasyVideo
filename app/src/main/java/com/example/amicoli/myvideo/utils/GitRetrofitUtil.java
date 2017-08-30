package com.example.amicoli.myvideo.utils;

import com.example.amicoli.myvideo.network.GitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Amicoli on 2017/4/22.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class GitRetrofitUtil {

    private String base_url;

    public GitRetrofitUtil(String base_url) {

    }

    public static final String BASE_URL = "http://live.bilibili.com/";
    private static GitClient gitClient ;
    private static Retrofit retrofit;
    static {
        Gson gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public GitClient getGitClient(){
        if(gitClient == null){
            gitClient = retrofit.create(GitClient.class);
        }
        return gitClient;
    }
}
