package com.ex.crawllinks.improved.impl;

import com.ex.crawllinks.impl.IPageUtils;
import com.ex.crawllinks.impl.JsoupWrapper;
import com.ex.crawllinks.impl.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AsyncJsoupWrapper implements Runnable {
    private JsoupWrapper jsoupWrapper;

    private IAsyncCrawler crawler;
    private IPageUtils pageUtils;
    private String url;
    private int depth;

    public AsyncJsoupWrapper(String url, int depth, IPageUtils pageUtils, IAsyncCrawler crawler) {
        this.pageUtils = pageUtils;
        this.url = url;
        this.depth = depth;
        this.crawler = crawler;
    }

    public String getUrl(){
        return url;
    }

    public List<Page> getPageLinks() {
        return jsoupWrapper.getPageLinks();
    }

    @Override
    public void run() {
        this.jsoupWrapper = new JsoupWrapper();
        this.jsoupWrapper.scan(pageUtils, url);
        crawler.done(getPageLinks(), getStatusCode(), depth);
    }

    private int getStatusCode() {
        return jsoupWrapper.getStatusCode();
    }
}

