package com.yaorange.luence;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * 查询
 */
public class LuenceQuery {

    public static void query(Query query) throws IOException, ParseException {
        Directory directory = FSDirectory.open(Paths.get("f://luence_index"));
        //创建indexReader
        IndexReader reader = DirectoryReader.open(directory);
        //创建indexSearch
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs topDocs = searcher.search(query, 10);
        System.out.println("匹配:" + topDocs.totalHits);
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            Document doc = searcher.doc(scoreDoc.doc);
            System.out.println("id:" + doc.get("id") + "-->name:" + doc.get("name"));
        }
    }

    /**
     *单词查询 精确匹配
     */
    public static Query queryByTerm() {
        Term term = new Term("name", "shangsan");
        TermQuery query = new TermQuery(term);
        return query;
    }

    /**
     *模糊查询--通配符
     */
    public static Query queryByWild(){
        WildcardQuery query = new WildcardQuery(new Term("name","shangsan"));
        return query;
    }

    public static void main(String[] args) throws IOException, ParseException {
        //query(queryByTerm());
        query(queryByWild());
    }

}
