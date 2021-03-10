package com.vezenkov.webmvcarticlesfileuploadthymeleaf.dao;

import com.vezenkov.webmvcarticlesfileuploadthymeleaf.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
