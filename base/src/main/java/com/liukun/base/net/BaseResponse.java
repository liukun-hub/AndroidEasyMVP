package com.liukun.base.net;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description: 统一接口返回的数据基类,其中results的类型是泛型,用于接收具体的数据类
 */
public class BaseResponse<T> {
    private static int SUCCESS_CODE = 200;//成功的code
    private int code;                   //响应码
    private String message;             //提示信息
    private T data;                  //返回的具体数据

    public boolean isSuccess() {
        return getCode() == SUCCESS_CODE;
    }

    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static void setSuccessCode(int successCode) {
        SUCCESS_CODE = successCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseReponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
