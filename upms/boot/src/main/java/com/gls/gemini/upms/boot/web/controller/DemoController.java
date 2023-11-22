package com.gls.gemini.upms.boot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    /**
     * 测试
     *
     * @param name 名称
     * @return 名称
     */
    @GetMapping("/test/{name}")
    public String test(@PathVariable String name) {
        return "hello " + name;
    }
}
