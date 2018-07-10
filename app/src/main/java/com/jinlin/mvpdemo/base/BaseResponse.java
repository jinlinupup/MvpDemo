package com.jinlin.mvpdemo.base;

/*********************************************************
 * BaseResponse
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/4
 *********************************************************/
public class BaseResponse<T> {

    /**
     * desc : 登录成功
     * status : 1000
     * data : {"user":"13111111111","token":"9527","uid":"1"}
     */

    private String desc;
    private int status;
    private T data;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
