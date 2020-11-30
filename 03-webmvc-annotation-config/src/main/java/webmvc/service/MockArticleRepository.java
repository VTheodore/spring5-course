package webmvc.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import webmvc.model.Article;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockArticleRepository implements ArticleRepository, InitializingBean {
    private  List<Article> articles;


    @Override
    public List<Article> getArticles() {
        return this.articles;
    }

    @Override
    public Article addArticle(Article article) {
        this.articles.add(article);
        return article;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.articles = new ArrayList<Article>() {{
            add(new Article("Welcome to Spring", "some content"));
            add(new Article("Some creative title", "some creative content"));
            add(new Article("Novelties in Spring 5", "another content"));
        }};
    }
}
