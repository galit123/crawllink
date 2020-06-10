package com.ex.crawllinks.improved.impl;

import com.ex.crawllinks.impl.Page;
import com.ex.crawllinks.impl.PageCrawler;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncPageCrawler extends PageCrawler implements IAsyncCrawler {
    private ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads

    private AsyncJsoupWrapper asyncJsoupWrapper;
    private int crawlingDepth;
    private int depth;
    private Page root;

    public AsyncPageCrawler(int crawlingDepth, Page root, int depth) {
        this.crawlingDepth = crawlingDepth;
        this.depth = depth;
        this.root = root;
        asyncJsoupWrapper = new AsyncJsoupWrapper(root.getPageURL(), this, this);

    }

    public void scan() {
        executor.execute(this.asyncJsoupWrapper);//calling execute method of ExecutorService
    }

    public void crawlPage() {
        for(int i = 0; i < depth; i++){ System.out.print(" "); } // leading spaces
        System.out.println("Start " + asyncJsoupWrapper.getUrl());

        scan();
        if (depth >= crawlingDepth) {
            return;
        }

    }

    public void shutDown(){
        executor.shutdown();
        while (!executor.isTerminated()) {   }
    }

    @Override
    public void done() {
        root.setPageLinks(asyncJsoupWrapper.getPageLinks());
        if (root.getPageLinks() != null) {
            for (Page link : root.getPageLinks()) {
                new AsyncPageCrawler(crawlingDepth, link, depth + 1).crawlPage();
            }
        }

        System.out.println("Done " + root.getPageURL());

    }
}
