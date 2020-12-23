package course.spring.workshopshampoos.dao;

import course.spring.workshopshampoos.entity.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
}
