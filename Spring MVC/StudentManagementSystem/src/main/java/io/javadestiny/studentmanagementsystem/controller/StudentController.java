package io.javadestiny.studentmanagementsystem.controller;

import io.javadestiny.studentmanagementsystem.entities.Student;
import io.javadestiny.studentmanagementsystem.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Handle methods to handle list students and return model and view
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/student/new")
    public String createStudentForm(Model model){
        //Create student object to hold data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public  String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "update_student";
    }

    @PostMapping("/students/{id}")
    public  String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){

        // Get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        //Save updated student object
        return "redirect:/students";
    }

    //Handle method to handle delete student request
    @GetMapping("students/remove/{id}")
    public String deleteStudent(@PathVariable Long id ){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
