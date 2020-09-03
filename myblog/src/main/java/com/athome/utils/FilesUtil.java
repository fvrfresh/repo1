package com.athome.utils;

import com.athome.domain.Article;
import com.athome.integration.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @ClassName FilesUtil
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/21 13:47
 * @Version 1.0
 */
@Component
public class FilesUtil {

    @Autowired
    private FileService service;

    public String writePostToFile(Article post) {
        String articleFile = post.getTitle();
        String pin = ArticleUtil.hanziToPin(articleFile);
        if (pin.length() > 0){
            articleFile = pin + ".md";
        }else{
            articleFile = articleFile + ".md";
        }
        String filePath = File.separator + post.getCategory() + File.separator + articleFile;
        service.writeFile(filePath, post.getContent());
        return articleFile;
    }
}
