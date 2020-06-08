package com.ex.crawllinks.impl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsoupWrapper {

    public void crawlPage(Page page) throws IOException {
        Connection connection = Jsoup.connect(page.getPageURL());
        Document document = connection.get();
        Elements linksOnPage = document.select("a[href]");

        for (Element link : linksOnPage) {
            Page linkPage = new Page(link.absUrl("href"));
            page.addLink(linkPage);
        }
    }

}
