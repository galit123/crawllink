package com.ex.crawllinks.impl;

import com.ex.crawllinks.errorhandling.CrawlLinksRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PageCrawler implements IPageUtils {
    private Set<String> alreadyVisited = new HashSet<String>();

    @Autowired
    private JsoupWrapper jsoupWrapper ;
    public static Set<String> notScannable = new HashSet<String>();

    static {
        notScannable.add("bmp");
        notScannable.add("jpg");
        notScannable.add("pdf");
        notScannable.add("png");
        notScannable.add("tiff");
        notScannable.add("jpeg");
        notScannable.add("gif");
        notScannable.add("mp4");
        notScannable.add("svg");
        notScannable.add("ico");
        notScannable.add("psd");
        notScannable.add("zip");
        notScannable.add("mp3");
        notScannable.add("wav");
        notScannable.add("zip");

    }

    public void initialize(String url){
        alreadyVisited.clear();
        alreadyVisited.add(url);
        if (!isValid(url)){
            throw new CrawlLinksRuntimeException("url is not valid");
        }
    }

    public void crawlPage(int crawlingDepth, Page parent, int depth) {
        for(int i = 0; i < depth;i++){ System.out.print("   "); } // leading spaces
        System.out.println("Start " + parent.getPageURL());

        jsoupWrapper.scan(this, parent.getPageURL());
        parent.setStatusCode(jsoupWrapper.getStatusCode());
        if (depth >= crawlingDepth) {
            return;
        }
        parent.setPageLinks(jsoupWrapper.getPageLinks());
        if (parent.getPageLinks() != null) {
            for (Page link : parent.getPageLinks()) {
                crawlPage(crawlingDepth, link, depth + 1);
            }
        }

        System.out.println("Done " + parent.getPageURL());
    }

    @Override
    public boolean isValid(String url) {
        return ((url != null) && (!url.isEmpty()));
    }

    @Override
    public boolean isScannable(String urlAddress) {

        String url = urlAddress;
        int inx = url.indexOf("?");
        if (inx != -1) {
            url = url.substring(inx);
        }
        inx = url.lastIndexOf(".");
        if (inx == -1) {
            return true;
        }
        String ext = url.substring(inx);

        if (ext.length() != 3) {
            return true;
        }
        if (notScannable.contains(ext)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isAlreadyVisited(String url) {
        if (alreadyVisited.contains(url)) {
            return true;
        }
        alreadyVisited.add(url);
        return false;
    }

 }

