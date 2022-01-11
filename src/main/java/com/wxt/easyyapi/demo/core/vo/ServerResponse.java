package com.wxt.easyyapi.demo.core.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ServerResponse<T> implements Serializable {
    private ResponseBody<T> body = new ResponseBody<>();// 响应体
    private Map<String, String> header = new HashMap<>();// 响应头

    {
        header.put("code", "1");
    }

    private ServerResponse() {

    }

    private ServerResponse(T data) {
        this.body.setData(data);
    }

    private ServerResponse(int code, String msg) {
        this.body.setCode(code);
        this.body.setMsg(msg);
    }

    private ServerResponse(int code, String msg, T data) {
        this.body.setCode(code);
        this.body.setMsg(msg);
        this.body.setData(data);
    }

    public ResponseBody<T> getBody() {
        return body;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    // 使之不在 json 序列化结果当中
    @JsonIgnore
    public boolean isSuccess() {
        // 将表示成功的响应码统一为 200
        return this.body.getCode() == 200;
    }

    @JsonIgnore
    public int getCode() {
        return this.body.getCode();
    }

    @JsonIgnore
    public T getData() {
        return this.body.getData();
    }

    @JsonIgnore
    public String getMsg() {
        return this.body.getMsg();
    }

    public static <T> ServerResponse<T> create(int code, String msg, T data) {
        return new ServerResponse<>(code, msg, data);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<>(data);
    }

    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<>();
    }

    public static <T> ServerResponse<T> createByError(int code, String msg) {
        return new ServerResponse<>(code, msg);
    }
}
