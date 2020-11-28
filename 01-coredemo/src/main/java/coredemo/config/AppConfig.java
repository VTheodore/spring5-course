package coredemo.config;

import coredemo.AnnotationAppContextDemo;
import coredemo.consumer.ArticleConsumer;
import coredemo.consumer.ConsoleArticleConsumer;
import coredemo.formatter.ArticleFormatter;
import coredemo.formatter.DefaultArticleFormatter;
import coredemo.provider.ArticleProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackageClasses = AnnotationAppContextDemo.class)
@PropertySource("classpath:article.properties")
public class AppConfig {
    @Bean(name = "formatter")
    public ArticleFormatter formatter() {
        return new DefaultArticleFormatter();
    }

    @Bean("consumer")
    public ArticleConsumer createConsumer(ArticleProvider provider, ArticleFormatter formatter, @Value("${message}") String message) { // proxy
        ConsoleArticleConsumer consumer = new ConsoleArticleConsumer();
        consumer.setArticleProvider(provider);
        consumer.setArticleFormatter(formatter);
        consumer.setMessage(message);
        return consumer;
    }
}
