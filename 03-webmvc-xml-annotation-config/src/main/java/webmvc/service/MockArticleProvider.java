package webmvc.service;

import org.springframework.stereotype.Service;
import webmvc.model.Article;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockArticleProvider implements ArticleProvider {
    @Override
    public List<Article> getArticles() {
        return new ArrayList<Article>() {{
            add(new Article("Welcome to Spring", "some content"));
            add(new Article("Some creative title", "some creative content"));
            add(new Article("Novelties in Spring 5", "another content"));
        }};
    }
}
