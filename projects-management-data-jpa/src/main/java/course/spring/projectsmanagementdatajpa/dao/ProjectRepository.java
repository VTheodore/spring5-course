package course.spring.projectsmanagementdatajpa.dao;

import course.spring.projectsmanagementdatajpa.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
