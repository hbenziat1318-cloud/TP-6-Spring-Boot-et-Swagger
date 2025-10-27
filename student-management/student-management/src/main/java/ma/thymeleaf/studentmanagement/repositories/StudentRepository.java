package ma.thymeleaf.studentmanagement.repositories;

import ma.thymeleaf.studentmanagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "students", collectionResourceRel = "students")
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findById(int id);

    Student findByNom(String nom);

    Student findByPrenom(String prenom);

    @Query("SELECT YEAR(s.dateNaissance), COUNT(s) FROM Student s GROUP BY YEAR(s.dateNaissance) ORDER BY YEAR(s.dateNaissance)")
    Collection<Object[]> findNbrStudentByYear();

    Student findByNomAndPrenom(String nom, String prenom);
}