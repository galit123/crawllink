package com.ex.crawllinks.improved.impl;

import com.ex.crawllinks.impl.Page;
import com.ex.crawllinks.impl.PageCrawler;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncPageCrawler extends PageCrawler implements IAsyncCrawler {
    private static ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads

    private int crawlingDepth;
    private int depth;
    private Page root;

    public AsyncPageCrawler(int crawlingDepth, Page root, int depth) {
        this.crawlingDepth = crawlingDepth;
        this.depth = depth;
        this.root = root;
    }

    public void crawlPage() {
        for(int i = 0; i < depth; i++){ System.out.print(" "); } // leading spaces
        System.out.println("Start " + root.getPageURL());

        if (depth >= crawlingDepth) {
            return;
        }
        executor.execute(new AsyncJsoupWrapper(root.getPageURL(), depth,this, this));//calling execute method of ExecutorService
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void shutDown(){
        executor.shutdown();
        while (!executor.isTerminated()) {   }
    }

    @Override
    public void done(List<Page> pageLinks, int statusCode, int depth) {
        root.setStatusCode(statusCode);
        root.setPageLinks(pageLinks);
        if (pageLinks != null) {
            for (Page link : pageLinks) {
                new AsyncPageCrawler(crawlingDepth, link, depth + 1).crawlPage();
            }
        }

        System.out.println("Done " + root.getPageURL());

    }
}
