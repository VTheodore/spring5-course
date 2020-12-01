package com.vezenkov.restmvc.init;

import com.vezenkov.restmvc.model.Post;
import com.vezenkov.restmvc.model.User;
import com.vezenkov.restmvc.service.PostService;
import com.vezenkov.restmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static com.vezenkov.restmvc.model.Role.*;

@Component
public class DataInitializer implements CommandLineRunner {
    private final PostService postService;

    private final UserService userService;

    @Autowired
    public DataInitializer(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    private static final List<User> SAMPLE_USERS = List.of(
            new User("Default", "Admin", "admin", "admin",
                    "https://lh3.googleusercontent.com/proxy/cGNVbclL0E2LBuUnIxUaC7d-wP_K18xwNUMVzCHmtxgdEtaknGpKCZz-rBVUWP46jCXJSPq6Va7hZ__JZVjG4EKwLx-Kezlk9Qtb5NDc9Gb-E1oq85KV",
                    Set.of(READER, AUTHOR, ADMIN)),
            new User("Default", "Author", "author", "author",
                    "https://cdn.iconscout.com/icon/premium/png-512-thumb/public-domain-user-618551.png",
                    Set.of(AUTHOR)),
            new User("Default", "Reader", "reader", "reader",
                    "https://www.publicdomainpictures.net/pictures/230000/velka/computer-user.jpg",
                    Set.of(READER))
    );

    private static final List<Post> SAMPLE_POSTS = List.of(
            new Post("New in Spring 5", "WebFlux is here ...",
                    "https://www.publicdomainpictures.net/pictures/40000/velka/spring-flowers-13635086725Z1.jpg",
                    List.of("spring", "new")),
            new Post("Reactive Programming in Spring", "Project Reactor is employed ...",
                    "https://www.publicdomainpictures.net/pictures/40000/velka/spring-flowers-13635086725Z1.jpg",
                    List.of("spring", "reactive")),
            new Post("Autowiring and DI", "Autowiring is a flexible way to inject components ...",
                    "https://www.publicdomainpictures.net/pictures/40000/velka/spring-flowers-13635086725Z1.jpg",
                    List.of("spring", "autowiring"))
    );

    @Override
    public void run(String... args) throws Exception {
        if (this.userService.getCount() == 0) {
            SAMPLE_USERS.forEach(this.userService::createUser);
        }

        if (this.postService.getCount() == 0) {
            SAMPLE_POSTS.forEach(post -> {
                post.setAuthorId(this.userService.getUserByUsername("author").getId());
                this.postService.addPost(post);
            });
        }
    }
}
