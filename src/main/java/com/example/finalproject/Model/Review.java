package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Comment should be not empty!")
    @Size(max = 50,message = "maximum character in comments is 50")
    @Column(columnDefinition = "varchar(50) not null")
    private String comment;

    @NotNull(message = "rating should be not null!")
    @Positive
    @Column(columnDefinition = "double not null")
    private double rating;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreated;

    //------------Relations---------------//
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
