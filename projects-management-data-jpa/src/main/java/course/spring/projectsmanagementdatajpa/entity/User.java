package course.spring.projectsmanagementdatajpa.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @NonNull
    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;

    @NonNull
    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;

    @NonNull
    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @NonNull
    @Size(min = 2, max = 30)
    @Column(unique = true)
    private String username;

    @NotNull
    @NonNull
    @Size(min = 5, max = 30)
    private String password;

    @NonNull
    @NotNull
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = Set.of(Role.EMPLOYEE);

    private boolean active = true;

    @NotNull
    @PastOrPresent
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @NotNull
    @PastOrPresent
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified = new Date();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "users")
    private Set<Project> projects = new HashSet<>();

    public User(@NonNull @NotNull @Size(min = 2, max = 20) String firstName, @NonNull @NotNull @Size(min = 2, max = 20) String lastName, @NonNull @NotNull @Email String email, @NotNull @NonNull @Size(min = 2, max = 30) String username, @NotNull @NonNull @Size(min = 5, max = 30) String password, @NonNull @NotNull Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
