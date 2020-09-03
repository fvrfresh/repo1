package com.athome.web;

import com.athome.domain.ImageCategory;
import com.athome.service.ArticleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/23 11:21
 * @Version 1.0
 */

@Controller
@RequestMapping("/articles")
public class ArticlesController {

    @GetMapping("/all")
    public String getCategory(Model model){
        model.addAttribute("all", "所有文章");
        return "all";
    }

    @Autowired
    ArticleService articleService;

    @GetMapping("/images")
    public String getAllImages() throws JsonProcessingException {
        List<Map<String, String>> imagePaths = articleService.findCategoryForImage();

        List<Object[]> categories = new LinkedList<>();
        imagePaths.stream().forEach(map -> {
            Object[] objects = map.values().toArray();
            categories.add(objects);
        });
        Map<Object, List<ImageCategory>> collect = categories.stream().map(el -> {
            ImageCategory category = new ImageCategory();
            category.setCategory(el[1].toString());
            category.setLogoFile(el[0].toString());
            return category;
        }).collect(Collectors.groupingBy(el -> {
            return el.getCategory();
        }));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(collect));
        return "error";
    }
}
