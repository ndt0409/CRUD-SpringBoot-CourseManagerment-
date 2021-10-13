package com.ndt.myweb.mywebapp.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/courses")
    public String showCourseList(Model model) {
        List<Course> listCourses = service.listAll();
        model.addAttribute("listCourses", listCourses);
        return "courses";
    }

    @GetMapping("/courses/new")
    public String showNewForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("pageTitle", "Thêm mới lớp học");
        return "course_form";
    }

    @PostMapping("/courses/save")
    public String saveCourse(Course course, RedirectAttributes ra) {
        service.save(course);
        ra.addFlashAttribute("message", "Thêm lớp học mới thành công");
        return "redirect:/courses";
    }

    @GetMapping("/courses/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Course course = service.get(id);
            model.addAttribute("course", course);
            model.addAttribute("pageTitle", "Chỉnh sửa lớp học (ID: " + id + ")");
            return "course_form";
        } catch (CourseNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/courses";
        }
    }

    @GetMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (CourseNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/courses";
    }

}
