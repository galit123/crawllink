package com.ex.crawllinks.impl;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private String pageURL;
    private List<Page> pageLinks = new ArrayList<Page>();

    public Page(String URL) {
        this.pageURL = URL;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String URL) {
        this.pageURL = URL;
    }

    public List<Page> getPageLinks() {
         return pageLinks;
    }
    public void addLink(Page page) {
        this.pageLinks.add(page);
    }
    public void setPageLinks(List<Page> links) {
        this.pageLinks = links;
    }
}
