package com.vezenkov.restmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Set;

@Document(collection = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Pattern(regexp = "[A-Za-z0-9]{24}")
    private String id;

    @NonNull
    @NotNull
    @Length(min = 3, max = 30)
    private String firstName;

    @NonNull
    @NotNull
    @Length(min = 3, max = 30)
    private String lastName;

    @NonNull
    @NotNull
    @Length(min = 3, max = 32)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NonNull
    @Length(min = 6)
    private String password;

    @NonNull
    @URL
    private String imageUrl;

    private Set<Role> roles = Set.of(Role.READER, Role.AUTHOR);

    private boolean active = true;

    @PastOrPresent
    private LocalDateTime created = LocalDateTime.now();

    @PastOrPresent
    private LocalDateTime modified = LocalDateTime.now();

    public User(@NonNull @NotNull @Length(min = 3, max = 30) String firstName, @NonNull @NotNull @Length(min = 3, max = 30) String lastName, @NonNull @NotNull @Length(min = 3, max = 32) String username, @NonNull @Length(min = 6) String password, @NonNull @URL String imageUrl, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.imageUrl = imageUrl;
        this.roles = roles;
    }
}
