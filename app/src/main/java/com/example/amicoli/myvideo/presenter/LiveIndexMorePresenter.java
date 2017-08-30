package com.example.amicoli.myvideo.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSONException;
import com.example.amicoli.myvideo.beans.movie.LiveIndexbean;
import com.example.amicoli.myvideo.iview.ILiveIndexMore;
import com.example.amicoli.myvideo.network.movie_live.MovieApiQueryBuilder;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by Amicoli on 2017/6/6.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class LiveIndexMorePresenter extends MvpBasePresenter<ILiveIndexMore> {

    public void getIndexMoreData(int paramInt1, int paramInt2, String paramString, final boolean isRefreshing){
        final ILiveIndexMore iLiveIndexMore = getView();
        if (iLiveIndexMore != null){
            Subscriber<ResponseBody>subscriber = new Subscriber<ResponseBody>() {
                @Override
                public void onCompleted() {
                }
                @Override
                public void onError(Throwable e) {
                    if (isRefreshing){
                        iLiveIndexMore.setRefreshError();
                        iLiveIndexMore.setdisSwiperefresh();
                    }else {
                        iLiveIndexMore.showFailed();
                    }
                }

                @Override
                public void onNext(ResponseBody body) {
                    try {
                        if (isRefreshing){
                            iLiveIndexMore.getIndexMoreList(getMovieDataMore(body.string()));
                            iLiveIndexMore.showSuccess();
                            iLiveIndexMore.setdisSwiperefresh();
                        }
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            MovieApiQueryBuilder.getInstance().getLiveIndexMore(paramInt1,paramInt2,paramString,subscriber);
        }
    }
    public  List<LiveIndexbean> getMovieDataMore(String bodyBean) throws JSONException, org.json.JSONException {
        ArrayList moredata = new ArrayList();
        moredata.clear();
        JSONArray jsarry = new JSONObject(bodyBean).getJSONArray("body");
        for (int i = 0;i<jsarry.length();i++){
            JSONObject jsobj = jsarry.getJSONObject(i);
            LiveIndexbean liveindexbean = new LiveIndexbean();
            liveindexbean.setType(1);
            liveindexbean.setScore(jsobj.getDouble("score"));
            liveindexbean.setDoubanId(jsobj.getString("doubanId"));
            liveindexbean.setTopicId(jsobj.getString("topicId"));
            liveindexbean.setImg(jsobj.getString("img"));
            liveindexbean.setName(jsobj.getString("name"));
            liveindexbean.setIndex(jsobj.getInt("index"));
            liveindexbean.setPid(jsobj.getString("pid"));
            liveindexbean.setMovieId(jsobj.getInt("movieId"));
            liveindexbean.setId(jsobj.getInt("id"));
            moredata.add(liveindexbean);
        }
        return moredata;
    }


}
