package ua.fan.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate admissionDate;

    @ManyToOne
    @JoinColumn(name = "studyGroup_id")
    private StudyGroup studyGroup;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Grade> grades;

    public Student(String firstName, String lastName, Integer age,
                   LocalDate admissionDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.admissionDate = admissionDate;
    }
}
