package com.gls.gemini.starter.web.jackson;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * java 8 时间默认序列化
 */
public class GeminiModule extends SimpleModule {

    /**
     * 构造方法
     */
    public GeminiModule() {
        super(PackageVersion.VERSION);
        // ======================= 时间序列化规则 ===============================
        // yyyy-MM-dd HH:mm:ss
        this.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DatePattern.NORM_DATETIME_FORMATTER));
        // yyyy-MM-dd
        this.addSerializer(LocalDate.class, new LocalDateSerializer(DatePattern.NORM_DATE_FORMATTER));
        // HH:mm:ss
        this.addSerializer(LocalTime.class, new LocalTimeSerializer(DatePattern.NORM_TIME_FORMATTER));
        // Long 类型序列化
        this.addSerializer(Long.class, ToStringSerializer.instance);

        // ======================= 时间反序列化规则 ==============================
        // yyyy-MM-dd HH:mm:ss
        this.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DatePattern.NORM_DATETIME_FORMATTER));
        // yyyy-MM-dd
        this.addDeserializer(LocalDate.class, new LocalDateDeserializer(DatePattern.NORM_DATE_FORMATTER));
        // HH:mm:ss
        this.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DatePattern.NORM_TIME_FORMATTER));
    }
}
