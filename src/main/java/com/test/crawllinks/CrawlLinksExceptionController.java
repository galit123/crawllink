package com.test.crawllinks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CrawlLinksExceptionController {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CrawlLinksResponse> exception(Exception exception) {
        CrawlLinksResponse response = new CrawlLinksResponse();
        response.setMessage("CrawlLinks failed :" + exception.getMessage());
        return new ResponseEntity<CrawlLinksResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = CrawlLinksRuntimeException.class)
    public ResponseEntity<CrawlLinksResponse> exception(CrawlLinksRuntimeException exception) {
        CrawlLinksResponse response = new CrawlLinksResponse();
        response.setMessage("CrawlLinks failed :" + exception.getMessage());
        return new ResponseEntity<CrawlLinksResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
