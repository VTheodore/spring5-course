package webmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import webmvc.model.Article;
import webmvc.service.ArticleRepository;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ArticleController {
    private final ArticleRepository repository;

    @Autowired
    public ArticleController(ArticleRepository repository) {
        this.repository = repository;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/")
    public String getIndex() {
        return "redirect:articles";
    }
    @GetMapping("/articles")
    public String getArticles(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("articles", this.repository.getArticles());

        return "articles";
    }

    @GetMapping("/new-article")
    public ModelAndView showForm() {
        return new ModelAndView("articleForm", "article", new Article());
//        return "articleForm";
    }

    @PostMapping("/submit-article")
    public String addArticle(@Valid @ModelAttribute("article") Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "articleForm";
        }

        this.repository.addArticle(article);
        return "redirect:articles";
    }
}
