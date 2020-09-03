package com.athome.web.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName EController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/13 14:30
 * @Version 1.0
 */
@Controller
@RequestMapping("/error")
public class EController implements ErrorController {

    @GetMapping
    public ModelAndView handleError(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
