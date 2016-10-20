package org.study.spring.mvc.controller;

import lombok.Data;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by niwei on 16/10/20.
 */
@Data
public class AbsController extends AbstractController {

    private String viewName;

    /**
     * Template method. Subclasses must implement this.
     * The contract is the same as for {@code handleRequest}.
     *
     * @param request
     * @param response
     * @see #handleRequest
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView(getViewName());
        String reqParam1 = ServletRequestUtils.getStringParameter(request, "reqParam1");
        modelAndView.addObject("reqParam1", reqParam1);

        return modelAndView;
    }
}
