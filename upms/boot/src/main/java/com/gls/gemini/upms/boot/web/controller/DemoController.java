package com.gls.gemini.upms.boot.web.controller;

import com.gls.gemini.upms.sdk.domain.vo.DemoRequestVo;
import com.gls.gemini.upms.sdk.domain.vo.DemoResponseVo;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 获取demo
     *
     * @param demoRequestVo demo请求vo
     * @return demo响应vo
     */
    @PostMapping("/getDemo")
    public DemoResponseVo getDemo(@RequestBody DemoRequestVo demoRequestVo) {
        return new DemoResponseVo().setName(demoRequestVo.getName()).setDescription("demo, hello world");
    }

    /**
     * 获取demo
     *
     * @param demoRequestVo demo请求vo
     * @return demo响应vo
     */
    @PostMapping("/getDemo2")
    public DemoResponseVo getDemo2(@RequestBody DemoRequestVo demoRequestVo) {
        throw new RuntimeException("test exception");
    }
}
