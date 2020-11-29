package webmvc.model;

import java.util.Date;

public class Article {
    private String title;

    private String content;

    private Date created;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
        this.created = new Date();
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
