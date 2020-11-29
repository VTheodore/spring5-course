package coredemo.consumer;

import coredemo.model.Article;
import coredemo.provider.ArticleProvider;

public class ConsumerFactory {
    private final ArticleProvider provider;

    public ConsumerFactory(ArticleProvider provider) {
        this.provider = provider;
    }

    public ArticleConsumer createConsumer() {
        this.provider.addArticle(new Article("Created by ConsumerFactory", "hello"));
        return new ConsoleArticleConsumer(this.provider);
    }
}
