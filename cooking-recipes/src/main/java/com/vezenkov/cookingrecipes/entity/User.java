package com.vezenkov.cookingrecipes.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import static com.vezenkov.cookingrecipes.entity.Role.USER;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NonNull
    @Length(min = 3, max = 64, message = "Name must be betweeen 3 and 64 characters long.")
    private String name;

    @NotNull
    @NonNull
    @Pattern(regexp = "^[A-Za-z]{3,15}$", message = "Username must be between 3 and 15 characters (characters only).")
    private String username;

    @NotNull
    @NonNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}\\[]:;<>,.?/~_+-=|\\\\]).{8,}$", message = "Password must be at least 8 characters, must contain at least one digit and at least one special character.")
    private String password;

    @NotNull
    @NonNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated
    private Set<Role> roles = Set.of(USER);

    private String imageUrl;

    @Length(max = 512, message = "Description should be no more than 512 characters.")
    private String aboutMeDescription;

    private boolean active;

    @PastOrPresent
    private Date created = new Date();

    @PastOrPresent
    private Date modified = new Date();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toString()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
