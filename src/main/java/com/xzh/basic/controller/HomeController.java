package com.xzh.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主页
 *
 * @author: 向振华
 * @date: 2019/08/16 15:31
 */
@Api(tags = "主页")
@RequestMapping("/")
@RestController
public class HomeController {

    @ApiOperation("主页")
    @GetMapping
    public String home() {
        return "success";
    }
}
