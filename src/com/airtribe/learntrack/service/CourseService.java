package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository = new CourseRepository();

    public void addCourse(String name, String desc, int duration, int trainerId) {
        InputValidator.validateName(name, "Course Name");
        InputValidator.validatePositiveNumber(duration, "Duration");

        int id = IdGenerator.getNextCourseId();
        Course course = new Course(id, name, desc, duration, trainerId);
        courseRepository.addCourse(course);
    }


    public List<Course> listCourses() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(int id) {
        Course course = courseRepository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with ID: " + id);
        }
        return course;
    }

    public void deactivateCourse(int id) {
        Course course = getCourseById(id);
        course.setActive(false);
        course.setStatus(CourseStatus.INACTIVE);
    }

    public void activateCourse(int id) {
        Course course = getCourseById(id);
        course.setActive(true);
        course.setStatus(CourseStatus.ACTIVE);
    }
}
