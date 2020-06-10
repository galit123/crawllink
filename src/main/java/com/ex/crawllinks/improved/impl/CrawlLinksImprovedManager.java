package com.ex.crawllinks.improved.impl;

import com.ex.crawllinks.impl.Page;
import org.springframework.stereotype.Component;

@Component
public class CrawlLinksImprovedManager {
    public Page crawlLinks(String url, Integer crawlingDepth) {
        Page root = new Page(url);
        AsyncPageCrawler pageCrawler = new AsyncPageCrawler(crawlingDepth, root, 0);
        pageCrawler.crawlPage();
        pageCrawler.shutDown();
        return root;
    }
}
