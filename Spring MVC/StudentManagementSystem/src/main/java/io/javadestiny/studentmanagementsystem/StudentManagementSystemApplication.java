package io.javadestiny.studentmanagementsystem;

import io.javadestiny.studentmanagementsystem.entities.Student;
import io.javadestiny.studentmanagementsystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(StudentManagementSystemApplication.class, args);

    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        /*Student s1 = new Student("Ketan","Parmar","ketan@gmail.com");
        studentRepository.save(s1);
        Student s2 = new Student("Harshil","Parmar","harshil@gmail.com");
        studentRepository.save(s2);
        Student s3 = new Student("Chhaya","Parmar","chhaya@gmail.com");
        studentRepository.save(s3);*/
    }
}
