package com.vitraya.URLExtract;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.Span;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class EntityExtractor {

    private final NameFinderME nameFinder;

    public EntityExtractor() throws IOException {
        InputStream modelIn = new FileInputStream("en-ner-person.bin");
        TokenNameFinderModel model = new TokenNameFinderModel(modelIn);
        modelIn.close();

        nameFinder = new NameFinderME(model);
    }

    public List<String> extractEntities(String text) {
        List<String> entities = new ArrayList<>();

        String[] tokens = SimpleTokenizer.INSTANCE.tokenize(text);
        Span[] nameSpans = nameFinder.find(tokens);

        for (Span span : nameSpans) {
            StringBuilder entity = new StringBuilder();
            for (int i = span.getStart(); i < span.getEnd(); i++) {
                entity.append(tokens[i]).append(" ");
            }
            entities.add(entity.toString().trim());
        }

        return entities;
    }

    public List<String> findRelationships(List<String> entities) {
        List<String> relationships = new ArrayList<>();

        for (int i = 0; i < entities.size() - 1; i++) {
            for (int j = i + 1; j < entities.size(); j++) {
                String entity1 = entities.get(i);
                String entity2 = entities.get(j);
                relationships.add(entity1 + " - " + entity2);
            }
        }

        return relationships;
    }
}
