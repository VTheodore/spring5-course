package coredemo;

import coredemo.config.AppConfig;
import coredemo.consumer.ArticleConsumer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationAppContextDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ArticleConsumer consumer = ctx.getBean("consumer", ArticleConsumer.class);
        consumer.consume();
    }
}
