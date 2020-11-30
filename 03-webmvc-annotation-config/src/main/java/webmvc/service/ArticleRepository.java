package webmvc.service;

import webmvc.model.Article;

import java.util.List;

public interface ArticleRepository {
    List<Article> getArticles();

    Article addArticle(Article article);
}
