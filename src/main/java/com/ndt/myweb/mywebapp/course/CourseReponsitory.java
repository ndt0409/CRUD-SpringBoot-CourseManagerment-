package com.ndt.myweb.mywebapp.course;

import org.springframework.data.repository.CrudRepository;

public interface CourseReponsitory extends CrudRepository<Course, Integer> {
    public Long countById(Integer id);

}
