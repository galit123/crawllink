package com.ex.crawllinks.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ex.crawllinks"})
public class CrawllinksApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrawllinksApplication.class, args);
	}

}
