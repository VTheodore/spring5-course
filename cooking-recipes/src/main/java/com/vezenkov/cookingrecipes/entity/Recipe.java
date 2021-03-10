package com.vezenkov.cookingrecipes.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;

    @NotNull
    @NonNull
    @Length(min = 3, max = 80, message = "Recipe name should be between 3 and 256 characters.")
    private String recipeName;

    @NotNull
    @NonNull
    @Length(min = 3, max = 256, message = "Brief description should be between 3 and 256 characters.")
    private String briefDescription;

    @NotNull
    @NonNull
    @Length(max = 2048, message = "Full description should be no more than 2048 characters.")
    private String fullDescription;

    @NotNull
    @NonNull
    @Positive
    private int timeToCook;

    @ElementCollection
    private List<@Pattern(regexp = "\\w+", message = "Ingredients must be alphanumerical characters.") String> ingredients = new ArrayList<>();

    private String pictureUrl;

    @ElementCollection
    private Set<@Pattern(regexp = "\\w+", message = "Keywords must be alphanumerical characters.") String> keywords;

    @PastOrPresent
    private Date created = new Date();

    @PastOrPresent
    private Date modified = new Date();
}
