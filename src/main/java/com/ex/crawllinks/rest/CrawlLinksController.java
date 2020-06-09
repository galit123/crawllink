package com.ex.crawllinks.rest;


import com.ex.crawllinks.impl.CrawlLinksManager;
import com.ex.crawllinks.impl.Page;
import com.ex.crawllinks.response.CrawlLinksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlLinksController {

    @Autowired
    private CrawlLinksManager crawlLinksManager;

//    @Autowired
//    private CrawlLinksImprovedManager crawlLinksImprovedManager;

    @GetMapping(path = "/crawllinks")
    public ResponseEntity<CrawlLinksResponse> crawlLinks(@RequestParam("URL") String URL,
                                     @RequestParam("crawlingDepth") Integer crawlingDepth  ) {
        Page page = null;
        page = crawlLinksManager.crawlLinks(URL, crawlingDepth);
        CrawlLinksResponse response = new CrawlLinksResponse("Crawler Finished Successfully", page);
        return new ResponseEntity<CrawlLinksResponse>(response, HttpStatus.OK);
    }

//    @GetMapping(path = "/crawllinks-improved")
//    public ResponseEntity<CrawlLinksResponse> crawlLinksImproved(@RequestParam("URL") String URL,
//                           @RequestParam("crawlingDepth") Integer crawlingDepth  ) {
//        Page page = crawlLinksImprovedManager.crawlLinks(URL, crawlingDepth);
//        CrawlLinksResponse response = new CrawlLinksResponse("Crawler Finished Successfully", page);
//        return new ResponseEntity<CrawlLinksResponse>(response, HttpStatus.OK);
//    }

}
