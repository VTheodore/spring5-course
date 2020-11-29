package coredemo.provider;

import coredemo.model.Article;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// @Primary -> alternative to qualifier
@Repository("provider")
@Qualifier("mockProvider")
public class MockArticleProvider implements ArticleProvider{
    private final AtomicInteger nextId = new AtomicInteger(0);
    private final Map<Integer, Article> articles = new ConcurrentHashMap<>();

    public MockArticleProvider() {
        new ArrayList<Article>() {{
            add(new Article("My first article", "mazalo"));
            add(new Article("New in Spring 5", "webflux e istinata bate"));
            add(new Article("DI Basics", "Dependency Injection for dummies"));
            add(new Article("Reactive Spring", "project reactor"));
        }}.forEach(this::addArticle);
    }

    @Override
    public List<Article> getArticles() {
        return new ArrayList<>(this.articles.values());
    }

    @Override
    public Article addArticle(Article article) {
        article.setId(this.nextId.incrementAndGet());
        return articles.put(article.getId(), article);
    }

    public static ArticleProvider createProvider() {
        MockArticleProvider provider = new MockArticleProvider();
        provider.addArticle(new Article("Added from factory method", "noice"));
        return provider;
    }
}
