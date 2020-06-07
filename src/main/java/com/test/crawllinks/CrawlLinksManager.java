package com.test.crawllinks;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class CrawlLinksManager {
    Set<String> alreadyVisited = new HashSet<String>();

    public Page crawlLinks(String URL, int crawlingDepth) throws IOException {
        alreadyVisited.clear();
        Page root = new Page(URL);
        crawlLinksInternal(crawlingDepth, 0, root);
        return root;
    }

    private void crawlLinksInternal(int crawlingDepth, int depth, Page parent) throws IOException {
        if (depth >= crawlingDepth ){
            return;
        }

        crawlPage(parent);
        for (Page link: parent.getPageLinks()){
            crawlLinksInternal(crawlingDepth, ++depth, link);
        }

    }

    private void crawlPage(Page page) throws IOException {
        if (alreadyVisited.contains(page.getPageURL())){
            return;
        }
        alreadyVisited.add(page.getPageURL());

        Connection connection = Jsoup.connect(page.getPageURL());
        Document htmlDocument = connection.get();
        Elements linksOnPage = htmlDocument.select("a[href]");

        for (Element link : linksOnPage) {
            Page linkPage = new Page(link.absUrl("href"));
            page.addLink(linkPage);
        }
    }
}
