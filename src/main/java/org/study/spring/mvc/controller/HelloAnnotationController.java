package org.study.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.study.spring.mvc.bean.Book;

/**
 * Created by niwei on 16/10/19.
 */
@Controller
@RequestMapping("/helloAnnotation")
public class HelloAnnotationController {

    @RequestMapping("/print")
    public String printHello(ModelMap model) {
        model.addAttribute("message", "我的 spring mvc 注解配置的例子!");

        return "helloPrint";
    }

    /**
     * 显示book信息
     *
     * @param model
     * @param selfDefineReqParam 自定义参数
     * @param book               Book的POJO
     * @return
     */
    @RequestMapping("/book")
    public String bookInfo(ModelMap model, String selfDefineReqParam, Book book) {
        model.addAttribute("selfDefineReqParam", selfDefineReqParam);
        model.addAttribute("book", book);

        return "helloBook";
    }
}
