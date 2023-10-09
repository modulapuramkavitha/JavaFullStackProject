package SpringProject.StudentManagementSystemUsingSpring.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import SpringProject.StudentManagementSystemUsingSpring.Model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School ,Integer>{
List<School> findBySchoolNameContainingIgnoreCase(String name);
}
