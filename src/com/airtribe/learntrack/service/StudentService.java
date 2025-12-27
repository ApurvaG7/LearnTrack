package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

    public void addStudent(String firstName, String lastName, String email, String batch) {
        InputValidator.validateName(firstName, "First Name");
        InputValidator.validateName(lastName, "Last Name");
        InputValidator.validateEmail(email);

        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, email, batch);
        studentRepository.addStudent(student);
    }

    public void addStudent(String firstName, String lastName, String batch) {
        InputValidator.validateName(firstName, "First Name");
        InputValidator.validateName(lastName, "Last Name");

        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, batch);
        studentRepository.addStudent(student);
    }

    public List<Student> listStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(int id) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }
        return student;
    }

    public void removeStudent(int id) {
        Student student = getStudentById(id);
        student.setActive(false);
    }

    public void updateStudent(int id, String firstName, String lastName, String email, String batch) {
        Student student = getStudentById(id);

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setBatch(batch);
    }

}
