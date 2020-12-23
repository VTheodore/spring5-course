package course.spring.projectsmanagementdatajpa.dao;

import course.spring.projectsmanagementdatajpa.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
