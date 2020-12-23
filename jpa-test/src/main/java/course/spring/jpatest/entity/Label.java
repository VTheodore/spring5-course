package course.spring.jpatest.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "labels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Label extends BaseEntity{

    @NonNull
    @NotNull
    @Size(min = 3, max = 255)
    private String title;

    @NonNull
    @NotNull
    @Size(min = 3, max = 255)
    private String subtitle;
}
