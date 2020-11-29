package webmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import webmvc.service.ArticleProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class GreetingController {
    private final ArticleProvider articleProvider;

    @Autowired
    public GreetingController(ArticleProvider articleProvider) {
        this.articleProvider = articleProvider;
    }

    @GetMapping("/articles")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Anonymous") String name, Model model) {
        model.addAttribute("articles", this.articleProvider.getArticles());
        model.addAttribute("name", name);
        return "mygreeting";
    }

    @PostMapping("/rm1")
    public String rm1(Model model, RedirectAttributes rm) {
        System.out.println("Entered rm1 method");

        rm.addFlashAttribute("modelKey", "modelValue");
        rm.addAttribute("nonflash", "nonflashvalue");
        model.addAttribute("modelkey2", "modelValue2");

        return "redirect:/rm2";
    }

    @GetMapping("/rm2")
    public String rm2(Model model, HttpServletRequest request) {
        System.out.println("Entered rm2 method");

        Map<String, Object> md = model.asMap();

        for (String modelKey : md.keySet()) {
            Object modelValue = md.get(modelKey);
            System.out.printf("%s ----- %s%n", modelKey, modelValue);
        }

        System.out.println("===========REQUEST DATA===========");
        Enumeration<String> reqEn = request.getParameterNames();

        while (reqEn.hasMoreElements()) {
            String s = reqEn.nextElement();
            System.out.println(s + "==" + request.getParameter(s));
        }

        return "mygreeting";
    }
}
