package course.spring.projectsmanagementdatajpa.init;

import course.spring.projectsmanagementdatajpa.dao.CompanyRepository;
import course.spring.projectsmanagementdatajpa.dao.ProjectRepository;
import course.spring.projectsmanagementdatajpa.dao.UserRepository;
import course.spring.projectsmanagementdatajpa.entity.Company;
import course.spring.projectsmanagementdatajpa.entity.Project;
import course.spring.projectsmanagementdatajpa.entity.Role;
import course.spring.projectsmanagementdatajpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    public static final List<Company> companies = List.of(
            new Company("ABC Ltd."),
            new Company("Sofia University"),
            new Company("Best Widgets Ltd."),
            new Company("Software AD")
    );

    public static final List<Project> projects = List.of(
            new Project("Build CI/CD Server", "Build custom continuous integration server for our projects ...",
                    70000.0, companies.get(3)),
            new Project("Create Furniture Web Site", "Build web site for our client selling furniture ...",
                    20000.0, companies.get(0)),
            new Project("Update SUSI with eLearning Functionality", "Add eLearning functionality to SUSI ...",
                    50000.0, companies.get(2)),
            new Project("Build IoT Control Access System", "Build custom IoT system controlling acces to to FMI building ...",
                    70000.0, companies.get(2))
    );

    public static final List<User> users = List.of(
            new User("Default", "Admin", "admin@gmail.com", "admin", "admin",
                    Set.of(Role.ADMIN)),
            new User("Ivan", "Petrov", "ivan@gmail.com", "ivan", "ivan123"),
            new User("Veronika", "Dimitrova", "vera@gmail.com", "veronika", "veronika",
                    Set.of(Role.EMPLOYEE, Role.MANAGER, Role.ADMIN))
    );


    private final UserRepository userRepository;

    private final CompanyRepository companyRepository;

    private final ProjectRepository projectRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository, CompanyRepository companyRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.projectRepository = projectRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (companyRepository.count() == 0) {
            companyRepository.saveAll(companies);
//            companies.forEach(companyRepository::save);
        }

        if (projectRepository.count() == 0) {
            projectRepository.saveAll(projects);
            projects.forEach(p -> p.getCompany().getProjects().add(p));
        }

        if (userRepository.count() == 0) {
            userRepository.saveAll(users);
            projects.get(0).getUsers().addAll(users);
            users.forEach(u -> u.getProjects().add(projects.get(0)));
        }

        companyRepository.findAll().forEach(System.out::println);
        projectRepository.findAll().forEach(System.out::println);
        userRepository.findAll().forEach(System.out::println);

    }
}
