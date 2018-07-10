package com.jinlin.mvpdemo.bean;

/*********************************************************
 * UserBean
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/4
 *********************************************************/
public class UserBean {

    /**
     * user : 13111111111
     * token : 9527
     * uid : 1
     */

    private String user;
    private String pwd;
    private String token;
    private String uid;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
