package com.ex.crawllinks.improved.impl;

import com.ex.crawllinks.impl.Page;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CrawlLinksImprovedManager {
    public Page crawlLinks(String url, Integer crawlingDepth) {
        long start = new Date().getTime();

        Page root = new Page(url);
        AsyncPageCrawler pageCrawler = new AsyncPageCrawler(crawlingDepth, root, 0);
        pageCrawler.crawlPage();



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // pageCrawler.shutDown();
        long end = new Date().getTime();
        long time = end - start;

        System.out.println("Finished in " + time / 1000 + " sec");

        return root;
    }
}
