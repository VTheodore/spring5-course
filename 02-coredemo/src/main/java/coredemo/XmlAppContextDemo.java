package coredemo;

import coredemo.consumer.ArticleConsumer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAppContextDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-config.xml");
        ArticleConsumer consumer = ctx.getBean("consumer", ArticleConsumer.class);
        consumer.consume();
    }
}
