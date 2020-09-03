package com.athome.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PostController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/11 21:28
 * @Version 1.0
 */
@Controller
@RequestMapping(path = "/archive/")
public class PostController {
    @GetMapping(path = "{post}")
    public String getPost(@PathVariable(value = "post") String post, Model model){

        model.addAttribute("title", post);
        return "post";
    }

    @GetMapping(path = "/carousel/{carousel}")
    public String getCarousel(@PathVariable(value = "carousel") String post, Model model){

        model.addAttribute("title", post);
        return "carousel";
    }
}
