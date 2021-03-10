package com.vezenkov.webmvcarticlesfileuploadthymeleaf.init;

import com.vezenkov.webmvcarticlesfileuploadthymeleaf.model.Article;
import com.vezenkov.webmvcarticlesfileuploadthymeleaf.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final ArticleService articleService;

    @Autowired
    public DataInitializer(ArticleService articleService) {
        this.articleService = articleService;
    }

    private static final List<Article> SAMPLE_ARTICLES = List.of(
            new Article("Foo Title", "Foo"),
            new Article("Spring 5", "Read more..."),
            new Article("I am a title", "I am content"),
            new Article("Lorem ipsum", "Something meaningful")
    );

    @Override
    public void run(String... args) throws Exception {
        if (this.articleService.articlesCount() == 0) {
            SAMPLE_ARTICLES.forEach(this.articleService::addArticle);
            log.info("Added articles : {}", this.articleService.getAllArticles());
        }
    }
}
