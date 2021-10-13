package com.ndt.myweb.mywebapp.course;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, name = "n_course")
    private String ncourse;
    @Column(length = 50, nullable = false, name = "quantity")
    private String quantity;
    @Column(nullable = false, unique = true, length = 45, name="email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNcourse() {
        return ncourse;
    }

    public void setNcourse(String ncourse) {
        this.ncourse = ncourse;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", ncourse='" + ncourse + '\'' +
                ", quantity=" + quantity +
                ", email='" + email + '\'' +
                '}';
    }
}
