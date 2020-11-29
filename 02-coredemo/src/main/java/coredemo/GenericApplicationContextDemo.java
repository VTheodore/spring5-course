package coredemo;

import coredemo.consumer.ArticleConsumer;
import coredemo.consumer.ConsoleArticleConsumer;
import coredemo.formatter.ArticleFormatter;
import coredemo.formatter.DefaultArticleFormatter;
import coredemo.provider.ArticleProvider;
import coredemo.provider.MockArticleProvider;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class GenericApplicationContextDemo {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new GenericApplicationContext();

        /* entirely programmatic */
        ctx.registerBean("formatter", DefaultArticleFormatter.class);
        ctx.registerBean("provider", MockArticleProvider.class);
        ctx.registerBean("consumer", ConsoleArticleConsumer.class,
                () -> new ConsoleArticleConsumer(
                        ctx.getBean("provider", ArticleProvider.class),
                        ctx.getBean("formatter", ArticleFormatter.class)));

        /* mixed */
//        ctx.registerBean("formatter", DefaultArticleFormatter.class);
//        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
//        xmlReader.loadBeanDefinitions(new ClassPathResource("app-config.xml"));
        ctx.refresh();

        ArticleConsumer consumer = ctx.getBean("consumer", ArticleConsumer.class);
        consumer.consume();
    }
}
