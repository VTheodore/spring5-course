package com.vezenkov.restmvc.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "posts")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @Pattern(regexp = "[A-Za-z0-9]{24}")
    private String id;

    @NonNull
    @NotNull
    @Length(min = 2, max = 80)
    private String title;

    @NonNull
    @Length(min = 2, max = 2048)
    private String content;

    @Pattern(regexp = "[A-Z-a-z0-9]{24}")
    private String authorId;

    @NonNull
    @URL
    private String imageUrl;

    private List<@Pattern(regexp = "^[\\w\\s-]+$") String> keywords = new ArrayList<>();

    @PastOrPresent
    private LocalDateTime created = LocalDateTime.now();

    @PastOrPresent
    private LocalDateTime modified = LocalDateTime.now();

    public Post(@NonNull @NotNull @Length(min = 2, max = 80) String title, @NonNull @Length(min = 2, max = 2048) String content, @NonNull @URL String imageUrl, List<@Pattern(regexp = "^[\\w\\s-]+$") String> keywords) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.keywords = keywords;
    }
}
