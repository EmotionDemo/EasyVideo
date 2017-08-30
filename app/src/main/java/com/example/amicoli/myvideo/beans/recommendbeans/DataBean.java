package com.example.amicoli.myvideo.beans.recommendbeans;

import java.util.List;

/**
 * Created by Amicoli on 2017/5/12.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class DataBean {
    /**
     * param :
     * type : recommend
     * style : medium
     * title : 热门焦点
     * body : [{"title":"全职高手 第06集 剑圣","cover":"http://i0.hdslb.com/bfs/archive/b2e34273011e8d068e775eec4e1c594b11b22ec5.jpg","uri":"bilibili://video/10309064","param":"10309064","goto":"av","play":1170386,"danmaku":95148,"rname":"国产动画","duration":1420,"name":"阅文漫镜头","is_ad":false,"cm_mark":0},{"title":"【高能说唱】papi酱的鬼畜放送","cover":"http://i0.hdslb.com/bfs/archive/4d2b89dd54d2220148997f2779e48a9855e5ff59.jpg","uri":"bilibili://video/10446731","param":"10446731","goto":"av","play":168114,"danmaku":608,"rname":"鬼畜调教","duration":152,"name":"猫店","is_ad":false,"cm_mark":0},{"title":"【香港电影】港片燃剪：我们终将被铭记，不只一世纪","cover":"http://i0.hdslb.com/bfs/archive/afb4e7b9838e7f8ef6ac4ba2ba84d58c6559b784.jpg","uri":"bilibili://video/10391188","param":"10391188","goto":"av","play":65595,"danmaku":654,"rname":"电影相关","duration":230,"name":"拖姜马","request_id":"1494575034619q172a18a61a26q79","src_id":1511,"is_ad":false,"is_ad_loc":true,"cm_mark":0,"client_ip":"223.99.199.178"},{"title":"底妆的正确打开方式","cover":"http://i0.hdslb.com/bfs/archive/32f307d6253b01bce031a9b230ef85032d5143f1.jpg","uri":"bilibili://video/10415608","param":"10415608","goto":"av","play":85792,"danmaku":383,"rname":"美妆","duration":295,"name":"鸭梨酱啊啊啊","is_ad":false,"cm_mark":0},{"title":"我宣布！德云色KTV党今天成立了！","cover":"http://i0.hdslb.com/bfs/archive/0fc539814c886f125e522bfc4f518cc9b8a16a68.png","uri":"bilibili://video/9296359","param":"9296359","goto":"av","play":70858,"danmaku":171,"rname":"网络游戏","duration":2565,"name":"陈以三x3","is_ad":false,"cm_mark":0},{"title":"【同性】暗影猎人 Malec - Start A Fire","cover":"http://i0.hdslb.com/bfs/archive/273e5839c0489a6660c640724726caaeee60e655.jpg","uri":"bilibili://video/9193092","param":"9193092","goto":"av","play":25985,"danmaku":67,"rname":"电视剧相关","duration":174,"name":"水合爱jaejoong","is_ad":false,"cm_mark":0}]
     * banner : {"top":[{"id":45772,"title":"影视0512","image":"http://i0.hdslb.com/bfs/archive/1c825fb4d52906047000502dac975782d522fc0c.jpg","hash":"d0f54daac7d106f45fd98cb4d6c6b6a6","uri":"http://www.bilibili.com/blackboard/activity-B1Uhci-lZ.html","resource_id":467,"request_id":"1494575034633","is_ad":false,"cm_mark":0,"index":1,"server_type":0},{"id":0,"title":"妃13","image":"https://i0.hdslb.com/bfs/archive/3f821382ac3fe63e8b2f5425e0916916693a3f59.jpg","hash":"01212af2e2bf4e84b9a2ed0ea6e6b06b","uri":"https://girl.biligame.com/yuyue","resource_id":467,"request_id":"1494575034590q172a18a61a87q137","creative_id":15478,"src_id":551,"is_ad":true,"is_ad_loc":true,"cm_mark":1,"ad_cb":"CPZ4EI4rGOcwIAAoADAAOKcEQh4xNDk0NTc1MDM0NTkwcTE3MmExOGE2MWE4N3ExMzdI3uH03L8rUgnlvrflt57luIJaCeWxseS4nOecgWIG5Lit5Zu9aAFwAXgAgAEAiAGCE5IBDjIyMy45OS4xOTkuMTc4","client_ip":"223.99.199.178","index":2,"server_type":1},{"id":45804,"title":"鬼畜54期","image":"http://i0.hdslb.com/bfs/archive/0dc79042fd20e5b9c5155eefb3eb8e5c08baf4ac.png","hash":"960d28d271e3f9605a0c01cd9d4648f2","uri":"http://www.bilibili.com/blackboard/kichiku-h5-053.html","resource_id":467,"request_id":"1494575034590q172a18a61a87q137","src_id":552,"is_ad":false,"is_ad_loc":true,"cm_mark":0,"client_ip":"223.99.199.178","index":3,"server_type":0}]}
     * ext : {"live_count":3743}
     */

    private String param;
    private String type;
    private String style;
    private String title;
    private BannerBean banner;
    private ExtBean ext;
    private List<BodyBean> body;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BannerBean getBanner() {
        return banner;
    }

    public void setBanner(BannerBean banner) {
        this.banner = banner;
    }

    public ExtBean getExt() {
        return ext;
    }

    public void setExt(ExtBean ext) {
        this.ext = ext;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }
}
