package com.athome.web;

import com.athome.domain.Article;
import com.athome.service.ArticleService;
import com.athome.storage.StorageService;
import com.athome.utils.ArticleUtil;
import com.athome.utils.FilesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/12 10:32
 * @Version 1.0
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    private ArticleService articleService;

    private FilesUtil filesUtil;
    private final StorageService storageService;


    @Autowired
    public AdminController(ArticleService articleService, FilesUtil filesUtil, StorageService storageService) {
        this.articleService = articleService;
        this.filesUtil = filesUtil;
        this.storageService = storageService;
    }

    @GetMapping
    public String admin(Model model) {
        Article default_post = articleService.findByTitle("default_post");
        if (default_post == null) {
            default_post = new Article("default_post","default_post.md");
            default_post.setId(0);
            default_post.setCategory("programming");
            default_post = ArticleUtil.buildArticle(default_post);
            default_post = ArticleUtil.buildArticleHtml(default_post);
            default_post.setDescription("用于测试的默认博文");
            default_post.setCreatedAt(new Date());
            default_post.setLogoFile("055-1.jpg");
        }else{
            default_post = ArticleUtil.buildArticle(default_post);
            default_post = ArticleUtil.buildArticleHtml(default_post);
        }
        model.addAttribute("article", default_post);
        return "admin";
    }

    @PostMapping("/articles")
    public String handlePost(Model model, Article post, @RequestParam("logoMultipartFile") MultipartFile file) {
        storageService.store(file);
        post.setLogoFile(file.getOriginalFilename());
        post.setHtmlString(ArticleUtil.markdownToHTML(post.getContent()));
        String articleFile = filesUtil.writePostToFile(post);
        post.setCreatedAt(new Date());
        model.addAttribute("article", post);
        post.setContent(articleFile);
        if (post.getCategory().equals("featured")){
            articleService.addFeaturedArticle(post);
            return "redirect:/admin";
        }
        articleService.addArticle(post);
        return "redirect:/admin";
    }
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable("id") String id, Model model) {
        Article article = articleService.findOne(Integer.parseInt(id));
        System.out.println(article);
        model.addAttribute("article", article);
        return "admin";
    }
}
