package com.ndt.myweb.mywebapp;

import com.ndt.myweb.mywebapp.course.Course;
import com.ndt.myweb.mywebapp.course.CourseReponsitory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CourseReponsitoryTest {
    @Autowired
    private CourseReponsitory repo;

    @Test
    public void testAddNew() {
        Course course = new Course();
        course.setNcourse("Java");
        course.setEmail("ndt0409@gmail.com");
        course.setQuantity("35");
        Course savedCourse = repo.save(course);
        Assertions.assertThat(savedCourse).isNotNull();
        Assertions.assertThat(savedCourse.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<Course> courses = repo.findAll();
        Assertions.assertThat(courses).hasSizeGreaterThan(0);
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void testUpdate() {
        Integer courseId = 1;
        Optional<Course> optionalCourse = repo.findById(courseId);
        Course course = optionalCourse.get();
        course.setEmail("duyduy.codewriter@gmail.com");
        repo.save(course);
        Course updateCourse = repo.findById(courseId).get();
        Assertions.assertThat(updateCourse.getEmail()).isEqualTo("duyduy.codewriter@gmail.com");
    }
    @Test
    public void testGet(){
        Integer courseId=2;
        Optional<Course> optionalCourse = repo.findById(courseId);
        Assertions.assertThat(optionalCourse).isPresent();
        System.out.println(optionalCourse.get());
    }
    @Test
    public void testDelete(){
        Integer courseId =2;
        repo.deleteById(courseId);
        Optional<Course> optionalCourse= repo.findById(courseId);
        Assertions.assertThat(optionalCourse).isNotPresent();
    }
}
