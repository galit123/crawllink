package com.ex.crawllinks.impl;

public interface IPage {
    boolean isValid(String url);
    boolean isScannable(String url);
    boolean isAlreadyVisited(String url);
}
