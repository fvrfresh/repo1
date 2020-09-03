package com.athome.integration.config;

import com.athome.utils.ArticleUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;

import java.io.File;

/**
 * @ClassName FileWriterIntegrationConfig
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/15 18:53
 * @Version 1.0
 */
@Configuration
public class FileWriterIntegrationConfig {

    @Bean
    @Transformer(inputChannel = "textInChannel",
                    outputChannel = "fileWriterChannel")
    public GenericTransformer<String, String> textTransformer(){
        return text -> text;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler fileWriter(){
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(ArticleUtil.getUserHome() + "/articles"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.REPLACE);
        handler.setAppendNewLine(true);
        return handler;
    }
}
