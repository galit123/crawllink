package com.ex.crawllinks.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CrawlLinksManager {
    @Autowired
    private PageCrawler pageCrawler;

    public Page crawlLinks(String url, int crawlingDepth) {
        System.out.println("Start CrawlLinks");

        long start = new Date().getTime();
        pageCrawler.initialize(url);

        Page root = new Page(url);
        pageCrawler.crawlPage(crawlingDepth, root,0);
        long end = new Date().getTime();
        long time = end - start;

        System.out.println("Finished in " + time / 1000 + " sec");
        return root;
    }
}
