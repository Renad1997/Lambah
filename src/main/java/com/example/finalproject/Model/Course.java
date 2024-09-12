package com.example.finalproject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private String learningMethod; //session type

    private String subject;

    private double price;

    private String courseDocuments;

    private int duration; // In weeks

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @OneToMany(mappedBy = "course")
    private List<Session> sessions;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews;

    @OneToMany(mappedBy = "course")
    private List<Exam> exams;

    @OneToMany(mappedBy = "course")
    private List<Document> documents;

    @OneToMany(mappedBy = "course")
    private List<Video> videos;

}
