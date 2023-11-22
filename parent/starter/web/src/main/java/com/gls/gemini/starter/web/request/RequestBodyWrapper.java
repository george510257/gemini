package com.gls.gemini.starter.web.request;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Request 包装类
 * 用于解决流只能读取一次的问题
 */
@Slf4j
public class RequestBodyWrapper extends HttpServletRequestWrapper {
    /**
     * 请求体
     */
    private final String requestBody;

    /**
     * 获取请求体
     *
     * @param request 请求
     * @throws IOException IO异常
     */
    public RequestBodyWrapper(HttpServletRequest request) throws IOException {
        super(request);
        requestBody = getRequestBody(request);
        log.info("requestBody: {}", requestBody);
    }

    /**
     * 获取请求体
     *
     * @param request 请求
     * @return 请求体
     * @throws IOException IO异常
     */
    private String getRequestBody(HttpServletRequest request) throws IOException {
        return request.getReader().lines().collect(Collectors.joining());
    }

    /**
     * 获取请求体
     *
     * @return 请求体
     * @throws IOException IO异常
     */
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    /**
     * 获取输入流
     *
     * @return 输入流
     * @throws IOException IO异常
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody.getBytes());
        return new ServletInputStream() {
            /**
             * 是否已经读取完毕
             *
             * @return 是否已经读取完毕
             */
            @Override
            public boolean isFinished() {
                return byteArrayInputStream.available() == 0;
            }

            /**
             * 是否准备好
             *
             * @return 是否准备好
             */
            @Override
            public boolean isReady() {
                return true;
            }

            /**
             * 设置读取监听器
             *
             * @param readListener 读取监听器
             */
            @Override
            public void setReadListener(ReadListener readListener) {
                throw new UnsupportedOperationException();
            }

            /**
             * 读取
             *
             * @return 读取
             * @throws IOException IO异常
             */
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }
}
