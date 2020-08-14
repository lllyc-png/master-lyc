package com.example.demo.controller.vo;


import java.util.HashMap;
import java.util.Map;

/**
 * 统一响应结构
 *
 * @param <T> data字段数据类型
 * @author 吕相成
 * @date 2020-05-27 11:03
 */
@SuppressWarnings("ALL")
public class ResponseVo<T> {
    private int code;

    private String msg;

    private T data;

    private ResponseVo() {
    }

    private ResponseVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseVo<T> ok(T data) {
        return new ResponseVo<>(200, "成功", data);
    }

    public static <T> ResponseVo<T> fail(int errorCode, String errorMessage) {
        return new ResponseVo<>(errorCode, errorMessage, null);
    }

    public Map<String, Object> toMap() {
        // 初始化HashMap，容量计算：ceil(3 / 0.75)
        Map<String, Object> map = new HashMap<>(4);
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
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

}

