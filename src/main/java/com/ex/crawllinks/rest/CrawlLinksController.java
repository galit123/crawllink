package com.ex.crawllinks.rest;


import com.ex.crawllinks.impl.CrawlLinksManager;
import com.ex.crawllinks.errorhandling.CrawlLinksRuntimeException;
import com.ex.crawllinks.impl.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
            throw new CrawlLinksRuntimeException(e);
        }
    }
}
