package com.vezenkov.webmvcarticlesfileuploadthymeleaf.web;

import com.vezenkov.webmvcarticlesfileuploadthymeleaf.model.Article;
import com.vezenkov.webmvcarticlesfileuploadthymeleaf.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticlesController {
    private static final String UPLOADS_DIR = "tmp";

    private final ArticleService articleService;

    @Autowired
    public ArticlesController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public String getArticles(Model model) {
        model.addAttribute("path", "articles");

        List<Article> allArticles = this.articleService.getAllArticles();
        model.addAttribute("articles", allArticles);
        log.debug("GET articles : {}", allArticles);

        return "articles";
    }

    @PostMapping(params = "edit")
    public String editArticle(@RequestParam("edit") Long editId, UriComponentsBuilder uriComponentsBuilder) {
        log.info("Editing article: {}", editId);
        URI uri = uriComponentsBuilder.path("/articles/article-form")
                .query("mode=edit&articleId={id}").buildAndExpand(editId).toUri();
        return "redirect:" + uri.toString();
    }

    @PostMapping(params = "delete")
    public String deleteArticle(@RequestParam("delete") Long deleteId, Model model) {
        log.info("Deleting article: {}", deleteId);
        this.articleService.deleteArticleById(deleteId);
        return "redirect:/articles";
    }

    @GetMapping("/article-form")
    public String getArticleForm(@ModelAttribute("article") Article article, Model model, @RequestParam(value = "mode", required = false) String mode, @RequestParam(value = "articleId", required = false) Long id) {
        String title = "Add new article";

        if ("edit".equals(mode)) {
            Optional<Article> foundArticle = this.articleService.getArticleById(id);

            if (foundArticle.isPresent()) {
                article = foundArticle.get();
                model.addAttribute("article", article);
                title = "Edit Article";
            }
        }

        model.addAttribute("title", title);
        return "article-form";
    }

    @PostMapping("/article-form")
    public String addArticle(@Valid @ModelAttribute("article") Article article, BindingResult bindingResult, @RequestParam("file") MultipartFile file, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "err");
            model.addAttribute("fileError", null);
            log.error("article {}", article);
            log.info("err : {}", bindingResult.getAllErrors());
            return "article-form";
        }

        log.info("POST Article {}", article);

        if (!file.isEmpty() && file.getOriginalFilename().length() > 0) {
            if (Pattern.matches("\\w+\\.(jpg|png)", file.getOriginalFilename())) {
                handleMultipartFile(file);
                article.setPictureUrl(file.getOriginalFilename());
            } else {
                model.addAttribute("fileError", "Submit picture [.jpg | .png]");
                return "article-form";
            }
        }

        if (article.getId() == null) {
            log.info("Add new Article: {}", article);
            this.articleService.addArticle(article);
        } else {
            article.setModified(new Date());
            log.info("Modifying Article: {}", article);
            this.articleService.updateArticle(article);
        }

        return "redirect:/articles";
    }

    private void handleMultipartFile(MultipartFile file) {
        String name = file.getOriginalFilename();
        long size = file.getSize();
        log.info("File {}, size {}", name, size);

        try {
            File currentDir = new File(UPLOADS_DIR);

            if (!currentDir.exists()) {
                currentDir.mkdirs();
            }

            String path = currentDir.getAbsolutePath() + "/" + file.getOriginalFilename();
            path = new File(path).getAbsolutePath();
            log.info(path);

            File f = new File(path);
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
