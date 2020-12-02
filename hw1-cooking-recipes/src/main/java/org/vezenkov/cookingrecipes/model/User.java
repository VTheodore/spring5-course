package org.vezenkov.cookingrecipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static org.vezenkov.cookingrecipes.model.ValidityStatus.ACTIVE;
import static org.vezenkov.cookingrecipes.model.ValidityStatus.SUSPENDED;

@Document(collection = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements UserDetails {
    @Id
    @Pattern(regexp = "^[A-Za-z0-9]{24}$", message = "Invalid author ID")
    private String id;

    @NotNull
    @NonNull
    private String name; // unique? why?

    @NotNull
    @NonNull
    @Pattern(regexp = "^[A-Za-z]+$", message = "Username must contain only word characters")
    @Length(min = 3, max = 15)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NonNull
    @Pattern(regexp = "^(?=.*[\\w])(?=.*\\d)(?=.*[\\W-_])[\\w\\d\\W]{8,}$", message = "Password must be at least 8 characters long, must contain at least 1 digit and at least 1 non-letter and non-digit character")
    @Length(min = 8)
    private String password;

    @NotNull
    @NonNull
    private Gender gender;

    private Set<Role> roles = Set.of(Role.USER);

    @Pattern(regexp = "^((\\w+/\\w+)?(;base64)?\\S+|(https?://)?([\\w\\-])+\\.{1}([a-zA-Z]{2,63})([/\\w-]*)*/?\\??([^#\\n\\r]*)?#?([^\\n\\r]*))$", message = "Invalid image url")
    private String imageUrl;

    @Length(max = 512)
    private String description;

    private ValidityStatus validityStatus = ACTIVE;

    @PastOrPresent
    private LocalDateTime created = LocalDateTime.now();

    @PastOrPresent
    private LocalDateTime modified = LocalDateTime.now();

    public User(@NotNull @NonNull String name, @NotNull @NonNull @Pattern(regexp = "^[A-Za-z]$", message = "Username must contain only word characters") @Length(min = 3, max = 15) String username, @NonNull @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$", message = "Password must be at least 8 characters long, must contain at least 1 digit and at least 1 non-letter and non-digit character") @Length(min = 8) String password, @NotNull @NonNull Gender gender, Set<Role> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.roles = roles;
    }

    public User(@NotNull @NonNull String name, @NotNull @NonNull @Pattern(regexp = "^[A-Za-z]$", message = "Username must contain only word characters") @Length(min = 3, max = 15) String username, @NonNull @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$", message = "Password must be at least 8 characters long, must contain at least 1 digit and at least 1 non-letter and non-digit character") @Length(min = 8) String password, @NotNull @NonNull Gender gender, Set<Role> roles, @Pattern(regexp = "^((\\w+/\\w+)?(;base64)?\\S+|(https?://)?([\\w\\-])+\\.{1}([a-zA-Z]{2,63})([/\\w-]*)*/?\\??([^#\\n\\r]*)?#?([^\\n\\r]*))$", message = "Invalid image url") String imageUrl, @Length(max = 512) String description) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.roles = roles;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toString()))
                .collect(Collectors.toList());
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return this.validityStatus.equals(ACTIVE);
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return this.validityStatus.equals(ACTIVE);
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return this.validityStatus.equals(ACTIVE);
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return this.validityStatus.equals(ACTIVE);
    }
}
