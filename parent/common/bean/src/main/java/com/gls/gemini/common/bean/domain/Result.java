package com.gls.gemini.common.bean.domain;

import com.gls.gemini.common.bean.enums.BaseEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 通用返回结果
 *
 * @param <T> 数据类型
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(BaseEnum baseEnum) {
        this.code = baseEnum.getCode();
        this.msg = baseEnum.getMessage();
    }

    public Result(BaseEnum baseEnum, T data) {
        this.code = baseEnum.getCode();
        this.msg = baseEnum.getMessage();
        this.data = data;
    }
}
