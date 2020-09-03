package com.athome.web.rest;

import com.athome.domain.*;
import com.athome.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName QuoteController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/26 18:03
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/archive",
        produces = "application/json")
@CrossOrigin(origins = "*")
public class AlbumController {

    @Autowired
    ArticleService articleService;


    @PostMapping(value = "/album",consumes = "application/json",produces = "application/json")
    public Map<Object, List<ImageCategory>> getAllImages(){
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
        return collect;
    }


}
