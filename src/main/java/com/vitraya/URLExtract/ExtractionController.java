package com.vitraya.URLExtract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class ExtractionController {

    private final EntityExtractor entityExtractor;

    @Autowired
    public ExtractionController(EntityExtractor entityExtractor) {
        this.entityExtractor = entityExtractor;
    }

    @PostMapping("/extract-text")
    public String extractText(@RequestBody Map<String,String> payload) {
        try {
            Document doc = Jsoup.connect(payload.get("url")).get();
            String pageText = doc.text();

            return pageText;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @PostMapping("/list-entities")
    public List<String> listEntities(@RequestBody Map<String,String> payload) {
        try {
            Document doc = Jsoup.connect(payload.get("url")).get();
            String pageText = doc.text();

            List<String> properNouns = entityExtractor.extractEntities(pageText);

            return properNouns;
        } catch (Exception e) {
            return Collections.singletonList("Error: " + e.getMessage());
        }
    }

    @PostMapping("/find-relationships")
    public List<String> findRelationships(@RequestBody Map<String,String> payload) {
        try {
            Document doc = Jsoup.connect(payload.get("url")).get();
            String pageText = doc.text();

            List<String> properNouns = entityExtractor.extractEntities(pageText);
            List<String> relationships = entityExtractor.findRelationships(properNouns);

            return relationships;
        } catch (Exception e) {
            return Collections.singletonList("Error: " + e.getMessage());
        }
    }
}
