package com.test.crawllinks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class CrawlLinksManager {

    @Autowired
    private JsoupWrapper jsoupWrapper;
    private Set<String> alreadyVisited = new HashSet<String>();

    public Page crawlLinks(String URL, int crawlingDepth) throws IOException {
        alreadyVisited.clear();
        Page root = new Page(URL);
        crawlPageLinks(crawlingDepth, 0, root);
        return root;
    }

    private void crawlPageLinks(int crawlingDepth, int depth, Page page) throws IOException {
        if (depth >= crawlingDepth ){
            return;
        }

        if (alreadyVisited.contains(page.getPageURL())){
            return;
        }
        alreadyVisited.add(page.getPageURL());

        if ((page.getPageURL() == null) || (page.getPageURL().isEmpty())){
            return;
        }

        jsoupWrapper.crawlPage(page);

        for (Page link: page.getPageLinks()){
            crawlPageLinks(crawlingDepth, ++depth, link);
        }
    }
}
