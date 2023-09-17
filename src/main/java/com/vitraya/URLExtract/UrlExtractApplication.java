package com.vitraya.URLExtract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class UrlExtractApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlExtractApplication.class, args);
	}

}
