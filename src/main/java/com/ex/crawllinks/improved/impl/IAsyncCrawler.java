package com.ex.crawllinks.improved.impl;

import com.ex.crawllinks.impl.Page;

import java.util.List;

public interface IAsyncCrawler{
    void done(List<Page> pageLinks, int statusCode, int depth);
}
