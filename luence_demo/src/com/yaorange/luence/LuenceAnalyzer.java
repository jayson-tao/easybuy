package com.yaorange.luence;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class LuenceAnalyzer {
    private static  String chinese ="今天是个好天气";
    public static void main(String[] args) throws IOException {


    }

    public static void analyzer(Analyzer analyzer,String text){
        TokenStream tokenStream = analyzer.tokenStream("name", text);

    }
}
