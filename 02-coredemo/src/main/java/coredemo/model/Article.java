package coredemo.model;

import lombok.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service("post")
@Scope("prototype")
@PropertySource("classpath:article.properties")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Article {
    private static int nextId = 0;

    private int id;

    @Value("${titles}")
    private String[] titles;

    @NonNull
    private String title;

    @NonNull
    private String content;

    @PostConstruct
    public void init() throws Exception {
        this.title = this.titles[nextId++ % titles.length];
        this.content = title + " content...";
    }
}
