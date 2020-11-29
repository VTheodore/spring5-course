package webmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webmvc.service.ArticleProvider;

@Controller
public class GreetingController {
    private final ArticleProvider provider;

    @Autowired
    public GreetingController(ArticleProvider provider) {
        this.provider = provider;
    }

    @GetMapping("/articles")
    public String getArticles(@RequestParam(value = "name", required = false, defaultValue = "Anonymous") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("articles", this.provider.getArticles());
        return "mygreeting";
    }
}
