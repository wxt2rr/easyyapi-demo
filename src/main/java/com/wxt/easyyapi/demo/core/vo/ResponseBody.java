package com.wxt.easyyapi.demo.core.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class ResponseBody<T> implements Serializable {
    private int code = 200;// 响应码（全局 200 表示成功）
    private String msg = "success";// 响应消息
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;// 响应数据

    public ResponseBody() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
