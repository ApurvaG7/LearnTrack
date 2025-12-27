package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    public void enrollStudent(int studentId, int courseId) {
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId);
        enrollmentRepository.addEnrollment(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus status) {
        for (Enrollment enrollment : enrollmentRepository.getAllEnrollments()) {
            if (enrollment.getId() == enrollmentId) {
                enrollment.setStatus(status);
                return;
            }
        }
        throw new EntityNotFoundException("Enrollment not found with ID: " + enrollmentId);
    }
}
