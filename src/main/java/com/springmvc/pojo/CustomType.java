package com.springmvc.pojo;

import java.io.Serializable;

/**
 * 自定义类型
 *
 * @author Zheng
 */
public class CustomType implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;

    public CustomType() {
    }

    public CustomType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
