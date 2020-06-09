package com.ex.crawllinks.response;

import com.ex.crawllinks.impl.Page;
import org.springframework.http.HttpStatus;

public class CrawlLinksResponse {
    private String message;
    private Page root;

    public Page getRoot() {
        return root;
    }

    public void setRoot(Page root) {
        this.root = root;
    }

    public CrawlLinksResponse(String message, Page root) {
        this.message = message;
        this.root = root;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
