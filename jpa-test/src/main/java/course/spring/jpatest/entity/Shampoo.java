package course.spring.jpatest.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "shampoos")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Shampoo extends BaseEntity{

    @NonNull
    @NotNull
    @Size(min = 3, max = 255)
    private String brand;

    @NonNull
    @NotNull
    @Positive
    private double price;

    @NonNull
    @NotNull
    @Positive
    private int size;

    @ManyToOne(optional = false)
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private Label label;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "shampoos_ingredients",
            joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    )
    private Set<Ingredient> ingredients;
}
