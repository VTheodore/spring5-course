package webmvc.service;

import webmvc.model.Article;

import java.util.List;

public interface ArticleProvider {
    List<Article> getArticles();
}
