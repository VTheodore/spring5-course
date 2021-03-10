package com.vezenkov.webmvcarticlesfileuploadthymeleaf.service;

import com.vezenkov.webmvcarticlesfileuploadthymeleaf.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> getAllArticles();

    Optional<Article> getArticleById(Long id);

    Article addArticle(Article article);

    Article updateArticle(Article article);

    Optional<Article> deleteArticleById(Long id);

    long articlesCount();
}
