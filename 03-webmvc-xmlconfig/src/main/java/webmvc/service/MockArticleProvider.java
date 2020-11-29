package webmvc.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import webmvc.model.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MockArticleProvider implements ArticleProvider{
    @Override
    public List<Article> getArticles() {
        return Arrays.asList(
                new Article("Welcome to Spring 5", "Spring 5 is great beacuse ..."),
                new Article("Dependency Injection", "Should I use DI or lookup ..."),
                new Article("Spring Beans and Wiring", "There are several ways to configure Spring beans.")
        );

    }
}
