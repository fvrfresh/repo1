package com.athome.integration.service;

import com.athome.integration.gateways.FileWriterGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

/**
 * @ClassName FileService
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/15 19:41
 * @Version 1.0
 */
@Service
public class FileService {

    @Autowired
    private FileWriterGateway fileWriter;

    public void writeFile(String fileName, String data){
        fileWriter.writeToFile(fileName,data);
    }

}
