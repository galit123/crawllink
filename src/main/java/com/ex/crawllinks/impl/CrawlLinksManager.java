package com.ex.crawllinks.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CrawlLinksManager {

    @Autowired
    private PageCrawler pageCrawler;

    public Page crawlLinks(String URL, int crawlingDepth) {
        System.out.println("Start CrawlLinks");

        long start = new Date().getTime();
        Page root = new Page(URL);
        pageCrawler.init(root);

        pageCrawler.crawlPage(crawlingDepth, 0, root);
        long end = new Date().getTime();
        long time = end - start;

        System.out.println("Finished in " + time / 1000 + " sec");
        return root;
    }

}
