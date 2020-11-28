package coredemo.provider;

import coredemo.model.Article;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository("provider")
public class MockArticleProvider implements ArticleProvider{
    private final AtomicLong nextId = new AtomicLong(0L);
    private final Map<Long, Article> articles = new ConcurrentHashMap<>();
    private ApplicationContext applicationContext;

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
