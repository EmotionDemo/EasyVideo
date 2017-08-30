package com.example.amicoli.myvideo.utils;

import com.example.amicoli.myvideo.beans.daily.StoryDetailBean;

/**
 * Created by Amicoli on 2017/5/22.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class HtmlUtils {
    public static String structHtml(StoryDetailBean storyDetailBean) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"img-wrap\">")
                .append("<h1 class=\"headline-title\">")
                .append(storyDetailBean.getTitle()).append("</h1>")
                .append("<span class=\"img-source\">")
                .append(storyDetailBean.getImage_source()).append("</span>")
                .append("<img src=\"").append(storyDetailBean.getImage())
                .append("\" alt=\"\">")
                .append("<div class=\"img-mask\"></div>");
        //news_content_style.css和news_header_style.css都是在assets里的
        String mNewsContent = "<link rel=\"stylesheet\" type=\"text/css\" href=\"news_content_style.css\"/>"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"news_header_style.css\"/>"
                + storyDetailBean.getBody().replace("<div class=\"img-place-holder\">", sb.toString());
        return mNewsContent;
    }
}
