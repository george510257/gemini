package com.gls.gemini.common.bean.constants;

/**
 * 通用常量
 */
public interface CommonConstants {

    /**
     * 包前缀
     */
    String PACKAGE_PREFIX = "com.gls.gemini";

    /**
     * properties配置前缀
     */
    String PROPERTIES_PREFIX = "gemini";
    /**
     * CPU核心数
     */
    int CPU_NUM = Runtime.getRuntime().availableProcessors();
    /**
     * 线程名称前缀
     */
    String THREAD_NAME_PREFIX = "GEMINI-THREAD-";
    /**
     * feign调用ID
     */
    String HEADER_FEIGN_ID = "feign-id";
}
