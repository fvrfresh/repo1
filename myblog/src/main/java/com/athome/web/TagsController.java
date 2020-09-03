package com.athome.web;

import com.athome.domain.Article;
import com.athome.domain.ArticleTransformed;
import com.athome.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/23 11:21
 * @Version 1.0
 */

@Controller
@RequestMapping("/tags")
public class TagsController {


    @GetMapping("/queryTags/{tags}")
    public String getTags(Model model, @PathVariable("tags") String tags){
        Pattern p = Pattern.compile("^:*(.+\\w+):*$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(tags);
        if(matcher.matches()){
            tags = matcher.group(1);
        }
        tags = tags.replaceAll(":+","&");
        System.out.println(tags);
        tags = tags.toUpperCase();
        model.addAttribute("tags", tags);
        return "tag";
    }


}
