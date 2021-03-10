package course.spring.jpatest.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "ingredients")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ingredient extends BaseEntity {

    @NonNull
    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NonNull
    @NotNull
    @Positive
    private double price;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "ingredients")
    private Set<Shampoo> shampoos;
}
