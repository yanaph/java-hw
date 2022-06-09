package ua.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class UniversityGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String groupName;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "universityGroup_student",
            joinColumns = @JoinColumn(name = "universityGroup_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "curator_id")
    private Curator curator;

    public UniversityGroup(String groupName, University university) {
        this.groupName = groupName;
        this.university = university;
    }
}
