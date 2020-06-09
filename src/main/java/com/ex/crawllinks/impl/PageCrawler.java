package com.ex.crawllinks.impl;

import com.ex.crawllinks.errorhandling.CrawlLinksRuntimeException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@Component
public class PageCrawler {

    private boolean isNotScannable(String urlAddress) {
        //check if valid image
        URLConnection connection = null;
        try {
            connection = new URL(urlAddress).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String contentType = connection.getHeaderField("Content-Type");
        if (contentType == null){
            return true;
        }
        if (contentType.startsWith("image/") ||
                contentType.startsWith("audio/") ||
                contentType.startsWith("video/") ||
                MediaType.APPLICATION_PDF_VALUE.equals(contentType)) {
            return true;
        }

        return false;
    }

    public void crawlPage(Page page)  {
        if (isNotScannable(page.getPageURL())){
            return;
        }
        Connection connection = Jsoup.connect(page.getPageURL());
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            throw new CrawlLinksRuntimeException(e);
        }
        Elements linksOnPage = document.select("a[href]");

        for (Element link : linksOnPage) {
            Page linkPage = new Page(link.absUrl("href"));
            page.addLink(linkPage);
        }
    }

}
