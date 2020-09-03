package com.athome.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/23 11:21
 * @Version 1.0
 */

@Controller
@RequestMapping("/category")
public class CategoryController {

    @GetMapping("/{category}")
    public String getCategory(Model model, @PathVariable String category){
        category = category.toUpperCase();
        model.addAttribute("category", category);
        return "category";
    }
}
