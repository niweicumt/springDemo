package org.study.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.study.spring.mvc.bean.MvcUser;
import org.study.spring.mvc.service.UserService;

/**
 * Created by niwei on 16/10/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/id/{id}")
    public String id(@PathVariable int id, ModelMap model) {
        MvcUser user = userService.queryUser(id);

        model.addAttribute("id", user.getId());
        model.addAttribute("userNo", user.getUserNo());

        return "user";
    }
}
