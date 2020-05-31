package com.app.staysafefinal;

public class FamilyRecycler {

    private String title, content, pageNumber;

    public FamilyRecycler() {
    }

    public FamilyRecycler(String title, String content, String pageNumber) {
        this.title = title;
        this.content = content;
        this.pageNumber = pageNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
