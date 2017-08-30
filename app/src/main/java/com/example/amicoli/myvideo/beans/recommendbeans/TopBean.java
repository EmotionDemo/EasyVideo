package com.example.amicoli.myvideo.beans.recommendbeans;

/**
 * Created by Amicoli on 2017/5/12.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class TopBean {
    /**
     * id : 45772
     * title : 影视0512
     * image : http://i0.hdslb.com/bfs/archive/1c825fb4d52906047000502dac975782d522fc0c.jpg
     * hash : d0f54daac7d106f45fd98cb4d6c6b6a6
     * uri : http://www.bilibili.com/blackboard/activity-B1Uhci-lZ.html
     * resource_id : 467
     * request_id : 1494575034633
     * is_ad : false
     * cm_mark : 0
     * index : 1
     * server_type : 0
     * creative_id : 15478
     * src_id : 551
     * is_ad_loc : true
     * ad_cb : CPZ4EI4rGOcwIAAoADAAOKcEQh4xNDk0NTc1MDM0NTkwcTE3MmExOGE2MWE4N3ExMzdI3uH03L8rUgnlvrflt57luIJaCeWxseS4nOecgWIG5Lit5Zu9aAFwAXgAgAEAiAGCE5IBDjIyMy45OS4xOTkuMTc4
     * client_ip : 223.99.199.178
     */

    private int id;
    private String title;
    private String image;
    private String hash;
    private String uri;
    private int resource_id;
    private String request_id;
    private boolean is_ad;
    private int cm_mark;
    private int index;
    private int server_type;
    private int creative_id;
    private int src_id;
    private boolean is_ad_loc;
    private String ad_cb;
    private String client_ip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public boolean isIs_ad() {
        return is_ad;
    }

    public void setIs_ad(boolean is_ad) {
        this.is_ad = is_ad;
    }

    public int getCm_mark() {
        return cm_mark;
    }

    public void setCm_mark(int cm_mark) {
        this.cm_mark = cm_mark;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getServer_type() {
        return server_type;
    }

    public void setServer_type(int server_type) {
        this.server_type = server_type;
    }

    public int getCreative_id() {
        return creative_id;
    }

    public void setCreative_id(int creative_id) {
        this.creative_id = creative_id;
    }

    public int getSrc_id() {
        return src_id;
    }

    public void setSrc_id(int src_id) {
        this.src_id = src_id;
    }

    public boolean isIs_ad_loc() {
        return is_ad_loc;
    }

    public void setIs_ad_loc(boolean is_ad_loc) {
        this.is_ad_loc = is_ad_loc;
    }

    public String getAd_cb() {
        return ad_cb;
    }

    public void setAd_cb(String ad_cb) {
        this.ad_cb = ad_cb;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }
}
