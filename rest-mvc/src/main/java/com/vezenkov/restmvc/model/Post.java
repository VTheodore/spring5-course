package com.vezenkov.restmvc.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String id;

    @NonNull
    private String title;

    @NonNull
    private String content;

    @NonNull
    private String author;

    private String imageUrl;

    private List<String> keywords = new ArrayList<>();

    private LocalDateTime created = LocalDateTime.now();

    private LocalDateTime modified = LocalDateTime.now();
}
