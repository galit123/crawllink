package com.ex.crawllinks.errorhandling;

public class CrawlLinksRuntimeException extends RuntimeException{
    public CrawlLinksRuntimeException(Throwable cause) {
        super(cause);
    }

    public CrawlLinksRuntimeException(String message) {
        super(message);
    }
}
