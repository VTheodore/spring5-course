package coredemo.consumer;

import coredemo.formatter.ArticleFormatter;
import coredemo.model.Article;
import coredemo.provider.ArticleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

public class ConsoleArticleConsumer implements ArticleConsumer {
    //    @Autowired
    private ArticleProvider articleProvider;
    private ArticleFormatter articleFormatter;

    private String message;

    public ConsoleArticleConsumer() {
    }

    //    @Autowired
    public ConsoleArticleConsumer(ArticleProvider articleProvider) {
        this.articleProvider = articleProvider;
    }

    public ConsoleArticleConsumer(ArticleProvider articleProvider, ArticleFormatter articleFormatter) {
        this.articleProvider = articleProvider;
        this.articleFormatter = articleFormatter;
    }

    //    @Autowired
    public void setArticleProvider(ArticleProvider articleProvider) {
        articleProvider.addArticle(new Article("Added article from setter", "hehe"));
        this.articleProvider = articleProvider;
    }

    //    @Autowired
    public void updateProviderAndMessage(ArticleProvider articleProvider, @Value("${message}") String message, ArticleFormatter articleFormatter) {
        articleProvider.addArticle(new Article("Added article from a method", "hehe2"));
        this.articleProvider = articleProvider;
        this.message = message;
        this.articleFormatter = articleFormatter;
    }

    public void setArticleFormatter(ArticleFormatter articleFormatter) {
        this.articleFormatter = articleFormatter;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void consume() {
        System.out.println(this.message);
        this.articleProvider.getArticles().forEach(article -> System.out.println(this.articleFormatter.formatArticle(article)));
    }
}
