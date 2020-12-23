package course.spring.projectsmanagementdatajpa.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Project extends BaseEntity{

    @NonNull
    @NotNull
    @Size(min = 2, max = 60)
    private String name;

    @NonNull
    @NotNull
    @Size(min = 2, max = 1024)
    private String description;

    @NonNull
    @NotNull
    @Positive
    private double budget;

    @PastOrPresent
    @Temporal(TemporalType.DATE)
    private Date startDate = new Date();

    private boolean finished = false;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "projects_users",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private Set<User> users = new HashSet<>();

    public Project(@NonNull @NotNull @Size(min = 2, max = 60) String name, @NonNull @NotNull @Size(min = 2, max = 1024) String description, @NonNull @NotNull @Positive Double budget, @NonNull @NotNull Company company) {
        this.name = name;
        this.description = description;
        this.budget = budget;
        this.company = company;
    }
}
