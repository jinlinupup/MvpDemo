package com.jinlin.mvpdemo.bean;

/*********************************************************
 * NewsBean
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public class NewsBean {

    /**
     * title : 我是标题01
     * content : 大家好我是内容啊，么么么么哒！请大家多多支持我！谢谢~
     * subject : 人民日报
     * time : 2018-08-18 16:25:30
     */

    private String title;
    private String content;
    private String subject;
    private String time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
