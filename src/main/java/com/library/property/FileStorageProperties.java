package com.library.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        //return uploadDir;
        return System.getProperty("user.dir")+"/src/main/resources/uploaded-images";
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
