package com.wp.springbootelastic;

import com.wp.springbootelastic.entity.Article;
import com.wp.springbootelastic.entity.Book;
import com.wp.springbootelastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class SpringbootElasticApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void contextLoads() {
        // 1.给es中索引保存一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("ElasticSearch消息");
        article.setAuthor("张三");
        article.setContent("hello world");

        // 构建一个索引功能
        Index index = new Index.Builder(article).index("test").type("news").build();
        // 执行
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // jest测试搜索
    @Test
    public void jestSearch(){
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        // 构建一个搜索功能
        Search search = new Search.Builder(json).addIndex("test").addType("news").build();
        // 执行
        SearchResult result = null;
        try {
            result = jestClient.execute(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 打印结果
        System.out.println(result.getJsonString());
    }

    @Test
    public void testBook(){
        Book book = new Book(1,"三国演义","罗贯中");
        bookRepository.index(book);
    }

    @Test
    public void testFindBook(){
        List<Book> byBookName = bookRepository.findByBookName("三");
        byBookName.forEach(System.out::println);
    }

}
