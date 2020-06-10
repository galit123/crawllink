package com.ex.crawllinks.impl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JsoupWrapper {
    private int statusCode;
    private IPageUtils pageUtils;
    private List<Page> pageLinks = null;

    public int getStatusCode() {
        return statusCode;
    }

    public List<Page> getPageLinks() {
        return pageLinks;
    }

    public void scan(IPageUtils pageUtils, String url) {
        if (!pageUtils.isValid(url)){
            return;
        }
        Connection connection = Jsoup.connect(url);
        Document document = null;
        this.statusCode = 0;
        try {
            document = connection.get();
            this.statusCode = connection.response().statusCode();
        } catch (IOException e) {
            this.statusCode = 999;
        }
        if (document == null){
            return;
        }

        if (!pageUtils.isScannable(url)){
            return;
        }
        Elements linksOnPage = document.select("a[href]");

        List<Page> pages = new ArrayList<Page>();
        for (Element link : linksOnPage) {
            String linkUrl = link.absUrl("href");
            if (pageUtils.isValid(linkUrl) && !(pageUtils.isAlreadyVisited(linkUrl))){
                Page linkPage = new Page(linkUrl);
                pages.add(linkPage);
            }
        }
        this.pageLinks = pages;
    }
}
