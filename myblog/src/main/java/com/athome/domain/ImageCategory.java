package com.athome.domain;

/**
 * @ClassName ImageCategory
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/29 19:21
 * @Version 1.0
 */
public class ImageCategory {

    private String category;
    private String logoFile;

    public ImageCategory() {
    }

    public ImageCategory(String category, String logoFile) {
        this.category = category;
        this.logoFile = logoFile;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLogoFile() {
        return logoFile;
    }

    public void setLogoFile(String logoFile) {
        this.logoFile = logoFile;
    }

    @Override
    public String toString() {
        return "ImageCategory{" +
                "category='" + category + '\'' +
                ", logoFile='" + logoFile + '\'' +
                '}';
    }
}
