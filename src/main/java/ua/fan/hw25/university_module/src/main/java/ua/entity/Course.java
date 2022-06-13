package ua.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Random;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Course {
    private final static Random RANDOM = new Random();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;

    private Integer difficultyLvl;

    @ManyToMany(mappedBy = "courseSet")
    private Set<Student> studentSet;

    public Course(String name) {
        this.name = name;
        difficultyLvl = RANDOM.nextInt(11);

    }
}