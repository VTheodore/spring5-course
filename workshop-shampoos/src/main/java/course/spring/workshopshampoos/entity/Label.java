package course.spring.workshopshampoos.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "labels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Label extends BaseEntity{

    @NotNull
    @Size(min = 2, max = 255)
    private String title;

    @NotNull
    @Size(min = 2, max = 255)
    private String subtitle;
}
