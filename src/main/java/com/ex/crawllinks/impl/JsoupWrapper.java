package com.ex.crawllinks.impl;

import com.ex.crawllinks.errorhandling.CrawlLinksRuntimeException;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JsoupWrapper {
    private int statusCode;
    private IPage pageUtil;
    private List<Page> pageLinks = null;

    public JsoupWrapper(IPage page) {
        pageUtil = page;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public List<Page> getPageLinks() {
        return pageLinks;
    }


    public void scan(String url) {
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

        if (!pageUtil.isScannable(url)){
            return;
        }
        Elements linksOnPage = document.select("a[href]");

        int size = linksOnPage.size();
        System.out.println("Children num = " + size);

        List<Page> pages = new ArrayList<Page>();
        for (Element link : linksOnPage) {
            String linkUrl = link.absUrl("href");
            if (pageUtil.isValid(linkUrl) && !(pageUtil.isAlreadyVisited(linkUrl))){
                Page linkPage = new Page(linkUrl);
                pages.add(linkPage);
            }
        }
        this.pageLinks = pages;
    }

}
