package com.gls.gemini.common.bean.util;

import com.gls.gemini.common.bean.domain.Result;
import com.gls.gemini.common.bean.enums.ResultEnum;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResultUtil {

    public Result<String> success() {
        return new Result<>(ResultEnum.SUCCESS);
    }

    public <T> Result<T> success(T data) {
        return new Result<>(ResultEnum.SUCCESS, data);
    }

    public <T> Result<T> success(String msg, T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), msg, data);
    }

    public <T> Result<T> failed() {
        return new Result<>(ResultEnum.FAILED);
    }

    public <T> Result<T> failed(String msg) {
        return new Result<>(ResultEnum.FAILED.getCode(), msg);
    }

    public <T> Result<T> failed(String msg, T data) {
        return new Result<>(ResultEnum.FAILED.getCode(), msg, data);
    }

    public <T> Result<T> failed(int code, String msg) {
        return new Result<>(code, msg);
    }

    public <T> Result<T> failed(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public <T> Result<T> failed(ResultEnum resultEnum) {
        return new Result<>(resultEnum);
    }

    public <T> Result<T> failed(ResultEnum resultEnum, T data) {
        return new Result<>(resultEnum, data);
    }
}
