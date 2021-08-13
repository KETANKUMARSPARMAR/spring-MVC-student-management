package io.javadestiny.studentmanagementsystem.repositories;

import io.javadestiny.studentmanagementsystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
