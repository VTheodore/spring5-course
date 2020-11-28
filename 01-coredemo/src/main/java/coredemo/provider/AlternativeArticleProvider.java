package coredemo.provider;

import coredemo.model.Article;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Repository("alternative")
@Qualifier("altProvider")
public class AlternativeArticleProvider implements ArticleProvider, ApplicationContextAware, InitializingBean {
    private final AtomicInteger nextId = new AtomicInteger(0);
    private final Map<Integer, Article> articles = new ConcurrentHashMap<>();
    private ApplicationContext ctx;

    public AlternativeArticleProvider() {
    }

    @Override
    public List<Article> getArticles() {
        return new ArrayList<>(this.articles.values());
    }

    @Override
    public Article addArticle(Article article) {
        article.setId(this.nextId.incrementAndGet());
        return this.articles.put(article.getId(), article);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        IntStream
                .range(1, 5)
                .mapToObj(n -> ctx.getBean("post", Article.class))
                .forEach(this::addArticle);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
