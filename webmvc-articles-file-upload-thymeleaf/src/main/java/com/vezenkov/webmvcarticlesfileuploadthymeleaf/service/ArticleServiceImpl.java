package com.vezenkov.webmvcarticlesfileuploadthymeleaf.service;

import com.vezenkov.webmvcarticlesfileuploadthymeleaf.dao.ArticleRepository;
import com.vezenkov.webmvcarticlesfileuploadthymeleaf.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return this.articleRepository.findAll();
    }

    @Override
    public Optional<Article> getArticleById(Long id) {
        return this.articleRepository.findById(id);
    }

    @Override
    public Article addArticle(Article article) {
        return this.articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Article article) {
        return this.articleRepository.save(article);
    }

    @Override
    public Optional<Article> deleteArticleById(Long id) {
        Optional<Article> toBeDeleted = this.getArticleById(id);

        if (toBeDeleted.isPresent()) {
            this.articleRepository.deleteById(id);
        }

        return toBeDeleted;
    }

    @Override
    public long articlesCount() {
        return this.articleRepository.count();
    }
}
