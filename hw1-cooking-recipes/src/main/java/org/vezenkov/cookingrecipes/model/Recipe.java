package org.vezenkov.cookingrecipes.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.Set;

@Document(collection = "recipes")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @Pattern(regexp = "^[A-Za-z0-9]{24}$", message = "Invalid recipe ID")
    private String id;

    @Pattern(regexp = "^[A-Za-z0-9]{24}$", message = "Invalid author ID")
    private String authorId;

    @NotNull
    @NonNull
    @Length(min = 3, max = 80)
    private String recipeName;

    @NotNull
    @NonNull
    @Length(min = 3, max = 256)
    private String briefDescription;

    @NotNull
    @NonNull
    @Length(min = 3, max = 2048)
    private String detailedDescription;

    @NotNull
    @NonNull
    @Positive
    private int timeNeeded;

    @NotNull
    @NonNull
    private Set<@Pattern(regexp = "^(\\w+(\\s\\w+|\\w*))+$") String> usedProducts;

    @NotNull
    @NonNull
    @Pattern(regexp = "^((\\w+/\\w+)?(;base64)?\\S+|(https?://)?([\\w\\-])+\\.{1}([a-zA-Z]{2,63})([/\\w-]*)*/?\\??([^#\\n\\r]*)?#?([^\\n\\r]*))$", message = "Invalid image url")
    private String imageUrl;

    private Set<@Pattern(regexp = "^\\w+$", message = "The collection contains invalid keyword/s") String> keywords;

    @PastOrPresent
    private LocalDateTime created = LocalDateTime.now();

    @PastOrPresent
    private LocalDateTime modified = LocalDateTime.now();

}
