package com.ex.crawllinks.improved.impl;

import com.ex.crawllinks.impl.IPageUtils;
import com.ex.crawllinks.impl.Page;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class asyncTest implements IPageUtils {

    static List<String> urls = new ArrayList<String>();
    static {
        urls.add("https://www.oracle.com/index.html#back");
        urls.add("https://www.oracle.com/index.html#search");
        urls.add("https://www.oracle.com/index.html#");
        urls.add("https://www.oracle.com/cloud/");
        urls.add("https://www.oracle.com/cloud/sign-in.html?intcmp=OHPpanel1");
        urls.add("https://www.oracle.com/cloud/hbr-global-survey-report.html");
        urls.add("https://www.oracle.com/news/connect/25-years-of-java-technology-community-family.html");
        urls.add("https://www.oracle.com/applications/");
        urls.add("https://www.oracle.com/index.html#back");
        urls.add("https://www.oracle.com/index.html#search");
        urls.add("https://www.oracle.com/index.html#");
        urls.add("https://www.oracle.com/cloud/");
        urls.add("https://www.oracle.com/cloud/sign-in.html?intcmp=OHPpanel1");
        urls.add("https://www.oracle.com/cloud/hbr-global-survey-report.html");
        urls.add("https://www.oracle.com/news/connect/25-years-of-java-technology-community-family.html");
        urls.add("https://www.oracle.com/applications/");
        urls.add("https://www.oracle.com/index.html#back");
        urls.add("https://www.oracle.com/index.html#search");
        urls.add("https://www.oracle.com/index.html#");
        urls.add("https://www.oracle.com/cloud/");
        urls.add("https://www.oracle.com/cloud/sign-in.html?intcmp=OHPpanel1");
        urls.add("https://www.oracle.com/cloud/hbr-global-survey-report.html");
        urls.add("https://www.oracle.com/news/connect/25-years-of-java-technology-community-family.html");
        urls.add("https://www.oracle.com/applications/");
        urls.add("https://www.oracle.com/index.html#back");
        urls.add("https://www.oracle.com/index.html#search");
        urls.add("https://www.oracle.com/index.html#");
        urls.add("https://www.oracle.com/cloud/");
        urls.add("https://www.oracle.com/cloud/sign-in.html?intcmp=OHPpanel1");
        urls.add("https://www.oracle.com/cloud/hbr-global-survey-report.html");
        urls.add("https://www.oracle.com/news/connect/25-years-of-java-technology-community-family.html");
        urls.add("https://www.oracle.com/applications/");

        urls.add("https://www.oracle.com/index.html#back");
        urls.add("https://www.oracle.com/index.html#search");
        urls.add("https://www.oracle.com/index.html#");
        urls.add("https://www.oracle.com/cloud/");
        urls.add("https://www.oracle.com/cloud/sign-in.html?intcmp=OHPpanel1");
        urls.add("https://www.oracle.com/cloud/hbr-global-survey-report.html");
        urls.add("https://www.oracle.com/news/connect/25-years-of-java-technology-community-family.html");
        urls.add("https://www.oracle.com/applications/");


        urls.add("https://www.oracle.com/index.html#back");
        urls.add("https://www.oracle.com/index.html#search");
        urls.add("https://www.oracle.com/index.html#");
        urls.add("https://www.oracle.com/cloud/");
        urls.add("https://www.oracle.com/cloud/sign-in.html?intcmp=OHPpanel1");
        urls.add("https://www.oracle.com/cloud/hbr-global-survey-report.html");
        urls.add("https://www.oracle.com/news/connect/25-years-of-java-technology-community-family.html");
        urls.add("https://www.oracle.com/applications/");
        urls.add("https://www.oracle.com/index.html#back");
        urls.add("https://www.oracle.com/index.html#search");
        urls.add("https://www.oracle.com/index.html#");
        urls.add("https://www.oracle.com/cloud/");
        urls.add("https://www.oracle.com/cloud/sign-in.html?intcmp=OHPpanel1");
        urls.add("https://www.oracle.com/cloud/hbr-global-survey-report.html");
        urls.add("https://www.oracle.com/news/connect/25-years-of-java-technology-community-family.html");
        urls.add("https://www.oracle.com/applications/");


        urls.add("https://www.oracle.com/index.html#back");
        urls.add("https://www.oracle.com/index.html#search");
        urls.add("https://www.oracle.com/index.html#");
        urls.add("https://www.oracle.com/cloud/");
        urls.add("https://www.oracle.com/cloud/sign-in.html?intcmp=OHPpanel1");
        urls.add("https://www.oracle.com/cloud/hbr-global-survey-report.html");
        urls.add("https://www.oracle.com/news/connect/25-years-of-java-technology-community-family.html");
        urls.add("https://www.oracle.com/applications/");


        urls.add("https://www.oracle.com/index.html#back");
        urls.add("https://www.oracle.com/index.html#search");
        urls.add("https://www.oracle.com/index.html#");
        urls.add("https://www.oracle.com/cloud/");
        urls.add("https://www.oracle.com/cloud/sign-in.html?intcmp=OHPpanel1");
        urls.add("https://www.oracle.com/cloud/hbr-global-survey-report.html");
        urls.add("https://www.oracle.com/news/connect/25-years-of-java-technology-community-family.html");
        urls.add("https://www.oracle.com/applications/");






        //urls.add("https://blogs.oracle.com/scm/creating-a-resilient-supply-chain-for-whatever-comes-next");
        urls.add("https://www.oracle.com/corporate/blog/oracle-epm-free-financial-planning-and-scenario-modeling-051320.html");
        urls.add("https://www.oracle.com/index.html?bcid=6161461684001");
        urls.add("https://www.oracle.com/applications/human-capital-management/employee-care-package.html");
        urls.add("https://www.oracle.com/customers/infrastructure/naveego/");


    }

    public Page test() {
        testScannsync();
        testScannAsync();

        return null;
    }

    private void testScannsync() {
        System.out.println("Start sync ");

        long start = new Date().getTime();

        int i = 0;
        for (i = 0; i < urls.size(); i++){
            new PageScanner(urls.get(i)).scan();
        }

        long end = new Date().getTime();
        long time = end - start;

        System.out.println("Finished sync in " + time / 1000 + " sec");


    }

    private ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads

    private void testScannAsync(){
        System.out.println("Start async ");

        long start = new Date().getTime();

        int i = 0;
        for (i = 0; i < urls.size(); i++){
            createAsyncScanner(urls.get(i));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {   }

        long end = new Date().getTime();
        long time = end - start;

        System.out.println("Finished async in " + time / 1000 + " sec");

    }

    private void createAsyncScanner(String url){
        Runnable scanner = new PageScanner(url );
        executor.execute(scanner);//calling execute method of ExecutorService

    }

    @Override
    public boolean isValid(String url) {
        return true;
    }

    @Override
    public boolean isScannable(String url) {
        return true;
    }

    @Override
    public boolean isAlreadyVisited(String url) {
        return true;
    }

    class PageScanner implements Runnable {

        private String url;

        public PageScanner(String url) {
            this.url = url;
        }

        public void scan(){
            System.out.println("scan " + this.url);

            Connection connection = Jsoup.connect(this.url);
            Document document = null;
            int statusCode = 0;
            try {
                document = connection.get();
                statusCode = connection.response().statusCode();
            } catch (IOException e) {
                statusCode = 999;
            }
            if (document == null) {
                return;
            }

            Elements linksOnPage = document.select("a[href]");

            List<Page> pages = new ArrayList<Page>();
            for (Element link : linksOnPage) {
                String linkUrl = link.absUrl("href");
                Page linkPage = new Page(linkUrl);
                pages.add(linkPage);
            }
        }



        @Override
        public void run() {
            scan();
        }
    }
}

