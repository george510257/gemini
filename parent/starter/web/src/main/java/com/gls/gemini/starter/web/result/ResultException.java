package com.gls.gemini.starter.web.result;

import com.gls.gemini.common.bean.enums.BaseEnum;
import lombok.Data;

@Data
public class ResultException extends RuntimeException {
    private final Integer code;
    private final String message;

    public ResultException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ResultException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public ResultException(Integer code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message;
    }

    public ResultException(BaseEnum baseEnum) {
        super(baseEnum.getMessage());
        this.code = baseEnum.getCode();
        this.message = baseEnum.getMessage();
    }

    public ResultException(BaseEnum baseEnum, Throwable cause) {
        super(baseEnum.getMessage(), cause);
        this.code = baseEnum.getCode();
        this.message = baseEnum.getMessage();
    }

    public ResultException(BaseEnum baseEnum, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(baseEnum.getMessage(), cause, enableSuppression, writableStackTrace);
        this.code = baseEnum.getCode();
        this.message = baseEnum.getMessage();
    }
}
