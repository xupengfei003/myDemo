package com.chatRobot.domain;

/**
 * Created by XuPengFei on 2017/8/3.
 */
public class UploadPicInfo {
    private String fileName;
    private String url;
    private String type;
    private String size;
    /**
     * 存储服务器路径
     */
    private String baseUrl;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
