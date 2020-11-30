package webmvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

public class Article {
    @NotNull
    @Size(min = 2, max = 100)
    private String title;

    @NotNull
    @Size(min = 3, max = 512)
    private String content;

    @NotNull
    @PastOrPresent
    private Date createdDate;

    public Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdDate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
