package com.test.crawllinks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class CrawlLinksController {

    @Autowired
    CrawlLinksManager crawlLinksManager;

    @GetMapping(path = "/crawllinks")
    public Page crawlLinks(@RequestParam("URL") String URL,
                           @RequestParam("crawlingDepth") Integer crawlingDepth  ) {
        Page page = null;
        try {
            return crawlLinksManager.crawlLinks(URL, crawlingDepth);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }
}
