package org.study.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by niwei on 16/10/19.
 */
@Controller
@RequestMapping("/helloAnnotation")
public class HelloAnnotationController {

    @RequestMapping("/print")
    public String printHello(ModelMap model) {
        model.addAttribute("message", "我的 spring mvc 注解配置的例子!");

        return "helloAnnotation";
    }
}
