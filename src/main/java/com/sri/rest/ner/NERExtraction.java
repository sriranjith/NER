package com.sri.rest.ner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.sri.rest.representations.NER;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class NERExtraction {

    private static NameFinderME nameFinder = null;

    static {
        // Load the model created above
        try {
            ClassLoader classLoader = NameFinderME.class.getClassLoader();
            InputStream inputStream = new FileInputStream(classLoader.getResource("ner/en-ner" +
                    "-date.bin").getFile());
            TokenNameFinderModel model = new TokenNameFinderModel(inputStream);
            nameFinder = new NameFinderME(model);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static List<NER> getEntityType(String sentence) {
        InputStream inputStreamTokenizer;
        List<NER> list = new ArrayList<>();
        try {
            ClassLoader classLoader = NameFinderME.class.getClassLoader();
            InputStream inputStream =
                    new FileInputStream(classLoader.getResource("ner/en-token" + ".bin").getFile());
            TokenizerModel tokenModel = new TokenizerModel(inputStream);
            TokenizerME tokenizer = new TokenizerME(tokenModel);
            String[] tokens = tokenizer.tokenize(sentence);

            Span nameSpans[] = nameFinder.find(tokens);
            // testing the model and printing the types it found in the input sentence
            for (Span name : nameSpans) {
                String entity = "";
                for (int i = name.getStart(); i < name.getEnd(); i++) {
                    entity += tokens[i] + " ";
                }
                list.add(new NER(name.getType(), entity, name.getProb()));
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getEntityType("John is a person today"));
    }
}