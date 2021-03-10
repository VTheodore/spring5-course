package com.vezenkov.webmvcarticlesfileuploadthymeleaf.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "articles")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NonNull
    @Size(min = 3, max = 60)
    private String title;

    @NotNull
    @NonNull
    @Size(min = 3, max = 2048)
    private String content;

    private String pictureUrl;

    @PastOrPresent
    private Date created = new Date();

    @PastOrPresent
    private Date modified = new Date();
}
