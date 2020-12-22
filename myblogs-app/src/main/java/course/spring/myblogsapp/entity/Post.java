package course.spring.myblogsapp.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotNull
    @Size(min = 3, max = 80)
    private String title;

    @NonNull
    @NotNull
    @Size(min = 3, max = 2048)
    private String content;

    @NonNull
    @NotNull
    @URL
    private String pictureUrl;

    @NonNull
    @NotNull
    @Size(min = 3, max = 80)
    private String author;

    @NonNull
    @ElementCollection
    private Set< @Size(min = 2, max = 30) String> keyWords;

    @NotNull
    @PastOrPresent
    private LocalDateTime created = LocalDateTime.now();

    @NotNull
    @PastOrPresent
    private LocalDateTime modified = LocalDateTime.now();
}
