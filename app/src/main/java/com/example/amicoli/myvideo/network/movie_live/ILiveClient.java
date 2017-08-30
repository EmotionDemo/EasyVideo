package com.example.amicoli.myvideo.network.movie_live;

import android.support.annotation.IntRange;


import com.example.amicoli.myvideo.beans.movie.LiveMovieBean;
import com.example.amicoli.myvideo.beans.movie.LivePlayInfoBean;
import com.example.amicoli.myvideo.beans.movie.MovieData;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Amicoli on 2017/5/28.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public interface ILiveClient {
    @GET("/api/more_doubantopic_list")
    Observable<MovieData>getIndex(@IntRange(from = 1L)@Query("page")int paramInt1, @Query("pageSize") int paramInt2);
    @GET("/api/more_douban_topic_items")
    Observable<ResponseBody>getIndexMore(@IntRange(from = 1L)@Query("page")int paramInt1, @Query("pageSize")int paramInt2, @Query("id")String paramString);
    @GET("/api/videos")
    Observable<LiveMovieBean>getMovies(@IntRange(from = 1L)@Query("page")int paramInt1,@IntRange(from=1L) @Query("page") int paramInt2);
    @GET("/api/videos")
    Observable<LiveMovieBean>getMovieSearch(@Query("keywords")String paramString);
    @GET("/api/video")
    Observable<LivePlayInfoBean>getPlayInfo(@Query("videoId")String paramString,@Query("Album")boolean paraBoolean);
}
