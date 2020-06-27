package com.liukun.androideasymvp.commom;

/**
 * Author: liukun on 2020/6/19.
 * Mail  : 3266817262@qq.com
 * Description: 事件的封装对象
 */
public class MessageWrap<T> {

    private T message;
    private int code;


    public MessageWrap(int code) {
        this.code = code;
    }

    public MessageWrap(int code, T message) {
        this.message = message;
        this.code = code;
    }

    public T getMessage() {
        return message;
    }


    public int getCode() {
        return code;
    }

    public static class Builder<T> {
        private T message;
        private int code;

        public Builder<T> setMessage(T message) {
            this.message = message;
            return this;
        }

        public Builder<T> setCode(int code) {
            this.code = code;
            return this;
        }

        public MessageWrap<T> create() {
            return new MessageWrap<T>(code, message);
        }
    }
}
