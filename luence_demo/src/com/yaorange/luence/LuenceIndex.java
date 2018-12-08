package com.yaorange.luence;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class LuenceIndex {
    public static void main(String[] args) throws IOException {
        Directory directory = FSDirectory.open(Paths.get("f://luence_index"));
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(directory, config);
        Document document = new Document();
        Field id = new TextField("id","1",Field.Store.YES);
        Field name = new TextField("name","shangsan",Field.Store.YES);
        document.add(id);
        document.add(name);
        Document document1 = new Document();
        Field id1 = new TextField("id","1",Field.Store.YES);
        Field name1= new TextField("name","shangsan good",Field.Store.YES);
        document.add(id1);
        document.add(name1);
        writer.addDocument(document);
        writer.addDocument(document1);
        writer.commit();
        writer.close();
    }
}
