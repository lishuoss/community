package com.test.coummity.controller;/*
 * @author 李硕
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class IndexController {
    @GetMapping("/index")
    public String indexa(){
        return "index";
    }
}
