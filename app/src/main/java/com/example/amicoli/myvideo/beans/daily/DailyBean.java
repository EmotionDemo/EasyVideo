package com.example.amicoli.myvideo.beans.daily;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Amicoli on 2017/5/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class DailyBean implements Serializable{


    /**
     * date : 20170517
     * stories : [{"images":["https://pic2.zhimg.com/v2-b250fe1a7190427bab5351b1a1d17c25.jpg"],"type":0,"id":9424946,"ga_prefix":"051714","title":"各式各样的冻干水果，营养程度跟新鲜水果差别大吗？"},{"images":["https://pic2.zhimg.com/v2-4db0c8eae74d332be0514ee5d1c74211.jpg"],"type":0,"id":9425287,"ga_prefix":"051714","title":"听着电视剧里的「皇上」「臣妾」「大人」，我有点不能忍"},{"images":["https://pic4.zhimg.com/v2-ffba4716be71a54518dd097f45f765bb.jpg"],"type":0,"id":9424237,"ga_prefix":"051712","title":"大误 · 你们人类太可怕了"},{"title":"在医院经常听到的「去拍个片子」，是怎么一个拍法？","ga_prefix":"051710","images":["https://pic3.zhimg.com/v2-b982d2e9cad6414185a52f59dbb92e9a.jpg"],"multipic":true,"type":0,"id":9424862},{"images":["https://pic1.zhimg.com/v2-c48668c026d4ce4c7668a38bb1ffb77c.jpg"],"type":0,"id":9424657,"ga_prefix":"051709","title":"所有互联网公司都要摆个乒乓球桌时，你得弄点其他的"},{"images":["https://pic2.zhimg.com/v2-17f9f7efd814ddb9bde6568f8a03ff25.jpg"],"type":0,"id":9423497,"ga_prefix":"051708","title":"BAT 中，谁能孕育出中国版 Netflix ？"},{"title":"参加戛纳电影节，都要做哪些准备？","ga_prefix":"051707","images":["https://pic1.zhimg.com/v2-3aa25dff12e19bc2c4b07eca8abdc5b4.jpg"],"multipic":true,"type":0,"id":9424457},{"images":["https://pic3.zhimg.com/v2-d96f51ba2c8f3c9e8e5a13575fecf726.jpg"],"type":0,"id":9424475,"ga_prefix":"051707","title":"以前机器翻译「有比没有强」，现在「有时比人还强」"},{"images":["https://pic4.zhimg.com/v2-a191a439a39ce466dc07a0d93ed1e523.jpg"],"type":0,"id":9424461,"ga_prefix":"051707","title":"在女厕所装个小便池？策划们在争执，设计师笑了"},{"images":["https://pic3.zhimg.com/v2-55a1105d8a990fe2e58f83930d7258f6.jpg"],"type":0,"id":9422525,"ga_prefix":"051706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-9fc5c3a7b05db66d029cd9809d020996.jpg","type":0,"id":9425287,"ga_prefix":"051714","title":"听着电视剧里的「皇上」「臣妾」「大人」，我有点不能忍"},{"image":"https://pic4.zhimg.com/v2-4e0a9f7e9fe8c711eff38cddd5f0a917.jpg","type":0,"id":9424457,"ga_prefix":"051707","title":"参加戛纳电影节，都要做哪些准备？"},{"image":"https://pic2.zhimg.com/v2-97ee40f59e52d92cdd2d53a279c253b5.jpg","type":0,"id":9423497,"ga_prefix":"051708","title":"BAT 中，谁能孕育出中国版 Netflix ？"},{"image":"https://pic1.zhimg.com/v2-2d44dccf658636c05cdf108867c2f8c4.jpg","type":0,"id":9424461,"ga_prefix":"051707","title":"在女厕所装个小便池？策划们在争执，设计师笑了"},{"image":"https://pic4.zhimg.com/v2-fb2d7b1b0ca551a2dd96f7d186d8ea37.jpg","type":0,"id":9422998,"ga_prefix":"051615","title":"汪曾祺先生逝世二十年，我们也很少再见到这样的文字"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    @Override
    public String toString() {
        return "DailyBean{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

}
